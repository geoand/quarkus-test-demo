# testing-demo project

The purpose of this project is to show various testing features of Quarkus as well as various handy Maven configurations

## Prerequisites

Because the project uses `quarkus-panache-mock` which will be released with Quarkus 1.5, you first need to build Quarkus locally using:

```bash
git clone --branch master --single-branch https://github.com/quarkusio/quarkus && cd quarkus && ./mvnw install -DskipTests -DskipITs -DskipDocs
```

## Run jvm tests

Using Java 14, execute:

```bash
mvn clean test
```

## Run all tests including native

Using Java 11, execute:

```bash
mvn clean verify -Dnative
```

## Build the application 

To build the JVM-mode application, using Java 14, execute:

```bash
mvn package -Dmaven.test.skip=true
```   

If instead you need to build the native application use,  

```bash
mvn package -Dmaven.test.skip=true -Dnative
```

The commands mentioned above skip the tests entirely using `-Dmaven.test.skip=true` as it's assumed they were previously executed. 
Removing the property will re-enable test execution.

## Run the application

To run the application, a postgresql instance needs to be running locally. 

The easiest way to do that is using docker like so:

```bash
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name quarkus_test -e POSTGRES_USER=quarkus_test -e POSTGRES_PASSWORD=quarkus_test -e POSTGRES_DB=quarkus_test -p 5432:5432 postgres:11.7
```

The database still needs to be created and potentially be seeded with data. For testing purposes only, the application can be built with

```properties
%prod.quarkus.hibernate-orm.database.generation=drop-and-create
%prod.quarkus.hibernate-orm.sql-load-script=import.sql
```

The JVM mode application can be start with:

```bash
java -Dquarkus.datasource.username=quarkus_test -Dquarkus.datasource.password=quarkus_test -jar target/testing-demo-1.0-SNAPSHOT-runner.jar
```     

The native application can be start with:

```bash
./target/testing-demo-1.0-SNAPSHOT-runner -Dquarkus.datasource.username=quarkus_test -Dquarkus.datasource.password=quarkus_test
```
