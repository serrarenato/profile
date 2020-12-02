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

#installing system dependencies
RUN apt-get update && \
    apt-get install -y apt-utils && \
    apt-get install -y netcat grep curl procps iproute2 net-tools inetutils-ping telnet lsof

#filebeat
ENV FILEBEAT_CFG=/etc/filebeat/filebeat.yml
ENV FILEBEAT_VERSION=6.5.1
ENV LOG_FILE=/var/log/jvm.log

RUN curl https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz -o /filebeat.tar.gz && \
    tar xzvf /filebeat.tar.gz && \
    cp filebeat-*/filebeat /usr/bin/filebeat

COPY filebeat.yml /

RUN mkdir -p /etc/filebeat && \
    mv /filebeat.yml /etc/filebeat/ && \
    cd / && \
    rm -rf filebeat* && \
    rm -rf /var/cache/apk/* && \
    chmod go-w /etc/filebeat/filebeat.yml

COPY startup.sh /application/startup.sh


# Start the application
ENTRYPOINT ["sh", "/application/startup.sh"]
