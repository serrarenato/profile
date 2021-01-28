# Repository Profile

> This project is a test about spring profiles in Java with a restclient call in microservice Server. 
IF you put profile dev the system will call the server service with a normal RestTemplate.
IF you put profile prod the system will call the server service with a LoadBalancer RestTemplate.    

tags: java profile spring loadbalancer


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

## Endpoints any profile:

- Get name object car: http://localhost:8888/car

You will need only one microservice server

## Endpoints prod profile:

- Get name object car: http://localhost:8888/car

You will need two or more microservice server, and must be configurated in file application-prod.properties:

```url.car.service.list: localhost:8080, localhost:8081```

## Security
The Client use the user and password to access the Server configured in file properties:
server.user=admin
server.password=12345
