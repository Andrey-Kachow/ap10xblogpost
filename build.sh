#!/bin/bash

dir=$(pwd)

export AP10X_RES_PATH=$dir"/src/main/resources/"

echo $AP10X_RES_PATH

mvn clean
mvn package
java -jar target/andreypopovblogpost-jar-with-dependencies.jar