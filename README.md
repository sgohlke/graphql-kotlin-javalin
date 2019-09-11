# graphql-kotlin-javalin

## How to run
Hello Kotlin will run on port 7000. You can run it either in IntelliJ Idea by running the WebService.kt class or using the docker file.

Use Dockerfile(example):
- Run maven package in project
- Execute **docker build -t kotlingql .** in project root folder
- Run **docker run --name kotlingql -d -p 7000:7000 kotlingql**

## Endpoints
- / : root endpoint, returns "Hello REST" and a current Datetime
- /person : Returns all Persons available
- /person/0 : From 0 to 2, returns specific Person with given index 
- /graphql : GraphQL post endpoint

### GraphQL endpoint

Send following body in post request to receive an answer from the GraphQL endpoint.

Get the federation SDL:
`{ _service { sdl } }`

Get all persons:
`{
   persons() {
       lastName
       firstName
       age
       id
     }
   }`
   
Get all persons with age 40:
`{
   persons(age:40) {
       lastName
       firstName
       age
       id
     }
   }`
   
Get the firstName of all persons with age 40 and lastName Meier:
   `{
      persons(age:40, lastName:"Meier") {
          firstName
        }
      }`