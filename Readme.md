# Repository Profile

> This project is a test about spring profiles in Java, I tried get different scenarios with file of properties and beans configurations.

tags: java profile spring


## Prerequisite
- Maven 3
- Java 8

## Install
- ```mvn clean install```

## Execute
One of the follow commands bellow:

- ```mvn spring-boot:run```
- ```mvn spring-boot:run -Dspring.profiles.active=dev ```
- ```mvn spring-boot:run -Dspring.profiles.active=prod ```

## Endpoints:

- Get all active profiles: http://localhost:8080/cep/profile

- Get endpoint to cep service: http://localhost:8080/cep

- Get name object car: http://localhost:8080/car

