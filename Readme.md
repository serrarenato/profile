# Repository Profile

> This project is a test about spring profiles in Java and LoadBalancer, I tried get different scenarios with file of properties and beans configurations.
> You must be started the client and the server projects.
> All Microservices have a filebeat to send file's logs to ELK.
> To Distributed tracing I put the lib  Spring Cloud Sleuth in both the microservices.
> To Security there is a lib called Spring Security

tags: java profile spring

## Spring Security
- TODO DO
## Prerequisite
- Maven 3
- Java 8

## Spring Cloud Sleuth
All logs of Apis have 4 new parameters.
INFO [Client Profile,2c2eadd178bac773,2c2eadd178bac773,true]
 - Client Profile = Name Application configured by bootstrap
 - second parameter(2c2eadd178bac773) = traceID it's the same in all microservice
 - third parameter(2c2eadd178bac773) = spanID it's new for each microservice
 - true = if must propagate the log.
 
INFO [Server Profile,2c2eadd178bac773,39a6a60e2def2f10,true 
## To start each microservice independently, use the links below:

[Client Readme](client/Readme.md)

[Server Readme](server/Readme.md)

## To start all microservices with docker use the command below:
```docker-compose build```
```docker-compose up -d```

## How docker was built.

There are one file in each project called DockerFile, this file copy the jar file of the project and make a image docker built in layers, thus we can start faster then only one layer.
We added some lines in the maven file in the build phase:

```			
<configuration>
    <layers>
        <enabled>true</enabled>
        <includeLayerTools>true</includeLayerTools>
    </layers>
</configuration>
```

To create the docker image, in the file Dockerfile we copy the jar file created in folder target and extracted it, thus each line is one layer in docker image.

```		
# Copy folders to image
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

# Start the application
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
```

## Actuator

This project have a actuator dependency and It can be access to URI:
 
/actuator

http://localhost:8080/actuator or http://localhost:8888/actuator

## ELK

ELK for storage of logs with the filebeat installed in containers to be send to Logstash 

http://localhost:5601/app/kibana

## Users
 - serra: role user
 - admin: role admin
 - both user have the same password: 12345
 
 



