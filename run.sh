#!/bin/bash
mvn clean install
# shellcheck disable=SC2164
cd target
java -jar products-api-0.1.0-SNAPSHOT.jar