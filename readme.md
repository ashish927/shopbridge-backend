# SHOPBRIDGE
Sales management service 

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) 

## Requirements

For building and running the application you need:

- [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven ](https://maven.apache.org)

## Running the application locally
  
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.thinkbridge.shopbridge.ShopbridgeApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## API-DOC
http://localhost:8080/shopbridge/v2/api-docs

## Swagger UI
http://localhost:8080/shopbridge/swagger-ui.html

## Postman collection
src/test/resources/POSTMAN/shopbridge.postman_collection.json

## Database Console
http://localhost:8080/shopbridge/h2-console

## Code Coverage
Use IDE plugin and Run project with code coverage