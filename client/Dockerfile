FROM openjdk:11-jre-slim as builder

# Copy jar file from target to builder image
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

#Extract Jar file in builder image
RUN java -Djarmode=layertools -jar application.jar extract


FROM openjdk:11-jre-slim

# Copy folders to image
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

# Start the application
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]