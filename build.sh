#!/bin/bash

dir=$(pwd)

export AP10X_RES_PATH=$dir"/src/main/resources/"

echo $AP10X_RES_PATH

mvn clean
#mvn compile
#mvn dependency:copy-dependencies
mvn package
#jar uf target/andreypopovblogpost.jar META-INF
java -jar target/andreypopovblogpost-jar-with-dependencies.jar