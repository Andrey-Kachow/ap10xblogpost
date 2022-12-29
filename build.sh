#!/bin/bash

dir=$(pwd)
home=$(echo ~)

export AP10X_RES_PATH=$dir"/src/main/resources/"
export AP10X_IMG_PATH=$home"/Pictures/ap10x"

echo $AP10X_RES_PATH

mvn clean
mvn package
java -jar target/andreypopovblogpost-jar-with-dependencies.jar