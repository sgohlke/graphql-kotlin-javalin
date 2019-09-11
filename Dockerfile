FROM openjdk:8-jre-alpine

EXPOSE 7000
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/javalin/my-javalin.jar"]

ADD target/graphqlKotlinJavalin-1.0-SNAPSHOT-shaded.jar /usr/share/javalin/my-javalin.jar