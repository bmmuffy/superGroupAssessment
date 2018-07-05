# superGroupAssessment  (Spring Boot, MySQL, JPA, Hibernate Rest API Using JWT tockens)

Build Restful CRUD API to be consumed by angular App 

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/bmmuffy/superGroupAssessment.git
```

**2. Create Mysql database**
```bash
create database movies_app
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/SuperGroupAssessment-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /movies
    
    POST /movies
    
    PUT /movies/{movieId}
    
    DELETE /movies/{movieId}

You can test them using postman or any other rest client or using the angular App.
```bash
git clone https://github.com/bmmuffy/movie-app.git
```


You should be ready to go....


