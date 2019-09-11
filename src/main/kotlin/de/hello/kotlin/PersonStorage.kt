package de.hello.kotlin

import com.expediagroup.graphql.TopLevelObject
import com.expediagroup.graphql.federation.FederatedSchemaGeneratorConfig
import com.expediagroup.graphql.federation.FederatedSchemaGeneratorHooks
import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import com.expediagroup.graphql.federation.toFederatedSchema
import graphql.schema.GraphQLSchema

object PersonStorage {
    val personList: MutableList<Person> = mutableListOf()

    init {
        personList.add(Person(1,"Meier", "Hans", 40))
        personList.add(Person(2,"Mahler", "Sandra", 32))
        personList.add(Person(3,"Huber", "Franz", 56))
    }

    // Generate the schema
    val config = FederatedSchemaGeneratorConfig(supportedPackages = listOf("de.hello"), hooks = FederatedSchemaGeneratorHooks(FederatedTypeRegistry(emptyMap())))
    val queries = listOf(TopLevelObject(PersonService()))
    val mutations = listOf(TopLevelObject(PersonUpdater()))

    fun getPersonSchema(): GraphQLSchema {
        return toFederatedSchema(config, queries, mutations)
    }

}