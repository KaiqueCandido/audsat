# Challenger Audsat

* Architectural Diagram: {APP_ROOT}/arquitetural_diagram.png
* Postman Collection: {APP_ROOT}/audsat.postman_collection.json

# Prerequisites
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* [Gradle 6+](https://gradle.org/whats-new/gradle-6/) 
* [Docker](https://www.docker.com/) 

## Execute project with docker

```
$ docker-compose up
```

### Execute project with gradle
```
$ gradle clean build

$ java {APP_ROOT}/buil/libs/audsat-0.0.1-SNAPSHOT.jar
```

### Basic Auth
Credentials:
* user: user
* pass: password

### Database H2
Console: http://localhost:8080/h2-console

Credentials:
* user: sa
* pass: password
