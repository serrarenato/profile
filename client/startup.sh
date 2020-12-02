#!/bin/bash

#waiting for filebeat
filebeat -e -c $FILEBEAT_CFG &

echo "teste"

java org.springframework.boot.loader.JarLauncher /
