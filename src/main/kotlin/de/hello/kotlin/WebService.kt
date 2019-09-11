package de.hello.kotlin

import com.expediagroup.graphql.extensions.print
import graphql.GraphQL
import io.javalin.Javalin
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

val logger = LoggerFactory.getLogger("de.hello")!!

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)
    app.get("/") { ctx -> ctx.result("Hello REST " + LocalDateTime.now()) }
            .get("/person") { ctx -> ctx.result("List of available Persons " + PersonStorage.personList.toString()) }
            .get("/person/:index") { ctx ->
                val personIndex = ctx.pathParam("index").toIntOrNull()
                ctx.json(if (personIndex == null) Person(1, "UNKNOWN", "UNKNOWN", 999) else PersonStorage.personList.get(ctx.pathParam("index").toInt()))
            }
            .post("/graphql") { ctx ->
                val query = ctx.bodyAsClass(GraphQLRequest::class.java).query
                logger.info("Query is: $query\n")
                val schema = PersonStorage.getPersonSchema()
                logger.info("Schema is\n" + schema.print() + "\n")
                /* If _service is null because SDL creation failed, maybe sending the broken sdl from schema.print to Gateway API might provide
                information about validation problems. E.g.
                ctx.json(GraphQLResponse.kt(ServiceSDL(_Service(schema.print(includeDefaultSchemaDefinition = false, includeDirectives = false)))))
                */
                val builder = GraphQL.newGraphQL(schema).build()
                val result = builder.execute(query).toGraphQLResponse()
                ctx.json(result)
            }
}