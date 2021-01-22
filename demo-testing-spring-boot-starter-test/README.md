# demo-testing-spring-boot-starter-test

This project represents a collection of examples to explain the use and configuration of **Spring Boot Starter Test**

Use 


This projects stands out for:

* Provide basic API REST with **Hello World (Greeting)**
* Provide **Java-based API test** with Spring Support
    * Mockito.spy
    * MockMvc + MockMvcResult with : @SpringBootTest and @WebMvcTest
    * JsonPath
    * JsonAssert
    * TestRestTemplate
    * @RestClientTest
    * MockRestServiceServer -> test and mock HTTP Response
    * WebTestClient


IMPORTANT : 

Use **@RunWith(SpringRunner.class)** for registers Spring JUnit 4 integration
Use **@ExtendWith(SpringExtension.class)** for registers Spring JUnit 5 integration

Change imports : @Test , @Before -> @BeforeEach, ....




## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring](https://spring.io)


Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter-parent** [2.3.4.RELEASE] : Spring Boot + Spring Framework
* **spring-boot-starter-test** [Spring Boot Version] : Spring Boot testing library (JUnit4 + Mockito + Hamcrest + AssertJ + JSONAsset + Json Path)





## Prerequisites

Define what elements are needed to install the software

* Java 8 installed (1.5+ version required)
* Maven installed  (3+)





## Installation

### Inspect

Optional : Inspect all transitive dependencies coming *-starter

```bash
mvn dependency:tree
```

Important : Spring Boot use specific versions


### Execution

Steps to follow

* Start a terminal
* To be located in the PATH of installation (the place where the project is located)
* Verify that the file "pom.xml" is available

Execute the following command

```bash
mvn clean install
```

The result will be the generation of an artifact in your Maven repository (local)

Generate : JAR File





## Testing

This project has tests : Unit + Integration

Execute with IDE or Maven





## Deploy

Spring Boot

* Deploy Method 1 : Application (Spring Boot File)
* Deploy Method 2 : Spring Boot Run
* Deploy Method 3 : Execute JAR



### Deploy Method 1 : Application (Spring Boot File)

1. Execute Application.java File

* Default 
* Configure Java "Run Configurations" IDE -> Use "Environment" with -Dspring.profiles.active=<id_profile>


### Deploy Method 2 : Spring Boot Run

1. Execute the following command

```bash
mvn spring-boot:run
```

Optional : use profile


### Deploy Method 3 : Execute JAR

Use Spring profiles with Maven Profiles -> Special Integration

* spring.profiles.active=@spring.profiles.active@
* enable resource filtering

Package the application in a single/fat JAR file (executable JAR + All dependencies + Embedded Servlet Container if its a web applications)

To run the jar file use the following command 

In this case define : "dev", "uat" and "pro"

1. Execute the following command

```bash
mvn package

or

mvn package -P<id_profile>
```

Execute

```bash
java -jar target/demo-testing-api-0.0.1-SNAPSHOT.jar
```

Use default environment -> dev or <id_profile> environment





## Use

Important : Beware of the configured port in the application-{id_profile}.yml


### Use Browser

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/greeting
```

And return JSON

```bash
{"id":1,"content":"Hello, World!","responseTime":"???"}
```

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/greeting?name=Acme
```

And return JSON

```bash
{"id":1,"content":"Hello, Acme!","responseTime":"???"}
```

### Use "curl"

Use the "curl"

```bash
curl -X GET http://localhost:8091/greeting

or

curl -X GET http://localhost:8091/greeting?name=Acme
```





## Use Actuators Endpoints

Important : Beware of the configured port

The actuators endpoints are configured in the application.yml
* Port : 8091
* Based-path : /manage

Example : http://localhost:8091/manage/info

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/manage/<endpoint>
```





## Swagger

The service will accept HTTP GET requests at :

```bash
http://localhost:8091/v2/api-docs
```

And return JSON with meta inforamtion of the API


Launching swagger UI swagger-ui.html


```bash
http://localhost:8091/swagger-ui.html
```





## Dockerize

Dockerize (Spring Boot + Docker)

1. Execute the following command

```bash
mvn clean install -P<id_profile>
```

2. Verify exist target/<artifact> -> JAR

3. Execute the following command

Create a Docker image File

```bash
docker build -t acme/demo-testing-api .
```

* Copy the generated JAR

4. Verify exist image created

5. Execute the following command

Create a Docker container

```bash
docker run -p 8091:8091 -t acme/demo-testing-api
```





## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning.
To see the available versions access the repository tags





## Authors

* **Víctor Madrid**
