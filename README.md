# Introduction

This is a Spring Boot application that accesses a MySql Database.  The data model is a `User` that has an id, name and email address.  There is one controller with two endpoints:

* `/demo/all` - lists all users  (GET REQUEST)
* `/demo/add` - add a user (POST REQUEST)

# Build and run

To build the uberjar execute
```
./mvnw clean package 
```
And run using `java -jar ./target/accessing-data-mysql-0.0.1-SNAPSHOT.jar`

# Using

To view the users
```
curl 'localhost:8080/demo/all'
```

To add a user
```
curl -X POST localhost:8080/demo/add -d name=First -d email=someemail@someemailprovider.com
```

