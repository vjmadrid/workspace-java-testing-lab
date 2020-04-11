# demo-testing-api-client

This project represents a basic API REST with **Hello World (Greeting)**

Invoke : localhost:<port>/greeting

And you receive : {"id":1,"content":"Hello, World!","responseTime":"???"}

This projects stands out for:

* Provide **Configuration classes** : Classes to configure the project (scanning package,...)
* Provide **Constant classes** : Classes to configure the project
* Provide **Basic classes** : Controller and Entity
* Provide **Properties Configuration File** with **Environment** (application-{environment}.yml)
* Provide **Log Configuration File** (logback.yml)
* Provide **Spring/Maven Profile Integration**
* Provide **Swagger** for document the Restful API
* Provide **Verify Files / Content with Verifier**
* Provide **Standard Surefire Test Filter with Profiles** (unit & integration test)
* Provide **Code Coverage with JACOCO**
* Provide **Java-based API test** with Spring Support
    * Mockito.spy
    * MockMvc + MockMvcResult with : @SpringBootTest and @WebMvcTest
    * JsonPath
    * JsonAssert
    * TestRestTemplate
    * @RestClientTest
    * MockRestServiceServer : test and mock HTTP Response
    * WebClient : Modern Alternative to RestTempale (support sync and asyn) -> require web flux


IMPORTANT : 

Use **@RunWith(SpringRunner.class)** for registers Spring JUnit 4 integration
Use **@ExtendWith(SpringExtension.class)** for registers Spring JUnit 5 integration

Change imports : @Test , @Before -> @BeforeEach, ....


Help with Dummy API

https://reqres.in/
https://jsonplaceholder.typicode.com/





## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring](https://spring.io)
* [Docker](https://www.docker.com/) - Container Technology

Dependencies with architecture projects

N/A

Third Party Dependencies

* **spring-boot-starter-parent** [2.2.0.RELEASE] : Spring Boot + Spring Framework
* **spring-boot-starter** [X] : Spring Boot Basic core
* **spring-boot-starter-test** [X] : Spring Boot testing library (JUnit4 + Mockito + Hamcrest + AssertJ + JSONAsset + Json Path)
* **spring-boot-starter-web** [X] : Spring Boot web library
* **spring-boot-devtools** [X] : Spring Boot Dev tools Library
* **spring-boot-starter-actuator** [X] : Spring Boot Actuators Library

* **springfox-swagger2** [2.9.2] : Swagger
* **springfox-swagger-ui** [2.9.2] : Swagger UI







## Prerequisites

Define what elements are needed to install the software

* Java 8 installed (1.5+ version required)
* Maven installed  (3+)
* Docker installed (19+)





## Installation

### Inspect

Optional : Inspect all transitive dependencies coming *-starter

```bash
mvn dependency:tree
```

Result for spring-boot-starter-test

```bash
+- org.springframework.boot:spring-boot-starter-test:jar:2.2.0.RELEASE:test
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:2.2.0.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:2.2.0.RELEASE:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO] |  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.12.1:compile
[INFO] |  |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.12.1:compile
[INFO] |  |  |  \- org.slf4j:jul-to-slf4j:jar:1.7.28:compile
[INFO] |  |  +- jakarta.annotation:jakarta.annotation-api:jar:1.3.5:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:1.25:runtime
[INFO] |  +- org.springframework.boot:spring-boot-test:jar:2.2.0.RELEASE:test
[INFO] |  +- org.springframework.boot:spring-boot-test-autoconfigure:jar:2.2.0.RELEASE:test
[INFO] |  +- com.jayway.jsonpath:json-path:jar:2.4.0:test
[INFO] |  |  \- net.minidev:json-smart:jar:2.3:test
[INFO] |  |     \- net.minidev:accessors-smart:jar:1.2:test
[INFO] |  |        \- org.ow2.asm:asm:jar:5.0.4:test
[INFO] |  +- jakarta.xml.bind:jakarta.xml.bind-api:jar:2.3.2:test
[INFO] |  |  \- jakarta.activation:jakarta.activation-api:jar:1.2.1:test
[INFO] |  +- org.junit.jupiter:junit-jupiter:jar:5.5.2:test
[INFO] |  |  +- org.junit.jupiter:junit-jupiter-api:jar:5.5.2:test
[INFO] |  |  |  +- org.opentest4j:opentest4j:jar:1.2.0:test
[INFO] |  |  |  \- org.junit.platform:junit-platform-commons:jar:1.5.2:test
[INFO] |  |  +- org.junit.jupiter:junit-jupiter-params:jar:5.5.2:test
[INFO] |  |  \- org.junit.jupiter:junit-jupiter-engine:jar:5.5.2:test
[INFO] |  +- org.junit.vintage:junit-vintage-engine:jar:5.5.2:test
[INFO] |  |  +- org.apiguardian:apiguardian-api:jar:1.1.0:test
[INFO] |  |  +- org.junit.platform:junit-platform-engine:jar:1.5.2:test
[INFO] |  |  \- junit:junit:jar:4.12:test
[INFO] |  +- org.mockito:mockito-junit-jupiter:jar:3.1.0:test
[INFO] |  +- org.assertj:assertj-core:jar:3.13.2:test
[INFO] |  +- org.hamcrest:hamcrest:jar:2.1:test
[INFO] |  +- org.mockito:mockito-core:jar:3.1.0:test
[INFO] |  |  +- net.bytebuddy:byte-buddy:jar:1.10.1:compile
[INFO] |  |  +- net.bytebuddy:byte-buddy-agent:jar:1.10.1:test
[INFO] |  |  \- org.objenesis:objenesis:jar:2.6:test
[INFO] |  +- org.skyscreamer:jsonassert:jar:1.5.0:test
[INFO] |  |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO] |  +- org.springframework:spring-core:jar:5.2.0.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-jcl:jar:5.2.0.RELEASE:compile
[INFO] |  +- org.springframework:spring-test:jar:5.2.0.RELEASE:test
[INFO] |  \- org.xmlunit:xmlunit-core:jar:2.6.3:test
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
