mvn clean
#mvn compile
#mvn dependency:copy-dependencies
mvn package
#jar uf target/andreypopovblogpost.jar META-INF
java -jar target/andreypopovblogpost-jar-with-dependencies.jar