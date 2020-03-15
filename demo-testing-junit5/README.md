# demo-testing-junit5

This project represents a collection of examples to explain the use and configuration of **JUnit 5**





## Technological Stack

* Java 8
* [Maven 3](https://maven.apache.org/) - Dependency Management

Dependencies with architecture projects

* If you consider using this option, uncomment the POM reference or use your own reference

Third Party Dependencies

* **commons-lang3** [3.9] : class utilities
* **commons-collections4** [4.4] : collection utilities
* **commons-io** [2.6] : class utilities for : file, streams, file comparator, file filters, ...

* **junit-platform-runner** [1.6.0] : platform unit test framework v5 (Add JUnit Platform + TestEngine API) -> Basic execute test
* **junit-platform-testkit** [1.6.0] : [Optional] platform provides Test Kit API for JUnit Platform
		

* **junit-jupiter-engine** [5.6.0] : unit test framework v5 (Add JUnit Platform + API) Use write test (include : annotations, etc.)
* **junit-vintage-engine** [5.6.0] : unit test framework for execute JUnit 3 and JUnit 4 (Add JUnit 4.13 transitively depends version vintage)
* **junit-jupiter-params : tool used for parameterized test


* **assertj-core** [3.11.1] : matching / asserts framework
* **mockito-core** [2.25.0] : mocking framework
* **mockito-junit-jupiter** [2.25.0] : mocking framework integration with Jupiter JUnit





## Prerequisites

Define what elements are needed to install the software

* Java 8 installed (1.5+ version required)
* Maven installed  (3+)





## Installation

Steps to follow 

* Start a terminal
* To be located in the PATH of installation (the place where the project is located)
* Verify that the file "pom.xml" is available

Execute the following command

```bash
mvn clean install
```

The result will be the generation of an artifact in your Maven repository (local)





## Deploy

N/A





## Use

N/A





## Versioning

**Note :** [SemVer](http://semver.org/) is used for the versioning. 
To see the available versions access the repository tags





## Authors

* **Víctor Madrid**
