# ===== BUILD =====


FROM java:8

RUN mkdir -p /opt/server/work
WORKDIR /opt/server/work

#copying module and executing

ADD /target/*.jar /opt/server/work/server.jar

ENTRYPOINT [ "java", "-jar", "server.jar"]
