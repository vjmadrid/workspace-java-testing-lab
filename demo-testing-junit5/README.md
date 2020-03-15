# demo-testing-junit5

Este proyecto representa a una serie de ejemplos sobre el uso y configuración de **JUnit5**





## Stack Tecnológico

* Java 8
* [Maven 3](https://maven.apache.org/) - Gestión de dependencias

Dependencias con proyectos de arquitectura

* Si se considera utilizar esta opción (descomentar la referencia)

Dependencias terceros

* **commons-lang3** [3.9] : Framework de utilidades para las clases
* **commons-collections4** [4.4] : Framework de utilidades para colecciones
* **commons-io** [2.6] : Framework de utilidades para trabajar con ficheros

* **junit-platform-runner** [1.6.0] : Platform unit test framework v5 (Add JUnit Platform + TestEngine API) -> Basic execute test
* **junit-platform-testkit** [1.6.0] : [Optional] Platform provides Test Kit API for JUnit Platform
		

* **junit-jupiter-engine** [5.6.0] : unit test framework v5 (Add JUnit Platform + API) Use write test (include : annotations, etc.)
* **junit-vintage-engine : unit test framework for execute JUnit ** [5.6.0] : unit test framework for execute JUnit 3 and JUnit 4 (Add JUnit 4.13 transitively depends version vintage)
* **junit-jupiter-params : Tool used for parameterized test


* **assertj-core** [3.11.1] : assertions for testing
* **mockito-core** [3.11.1] : mocking framework
* **mockito-junit-jupiter** [2.25.0] : mocking framework integration with Jupiter JUnit





## Prerrequisitos

Se definen que elementos se necesitan para instalar el software

* Tener instalado Java 8 (Se requiere versión 1.5+)
* Tener instalado Maven (Se aconseja que sea 3+)





### Instalación

Pasos a seguir 

* Arrancar la consola
* Situarse en el PATH de instalación (el lugar donde se encuentra el proyecto)
* Verificar que se encuentra disponible el fichero "pom.xml"

Ejecutar el siguiente comando

```bash
mvn clean install
```

El resultado será la generación de un artefacto en tu repositorio maven





## Testing

Este proyecto NO dispone de test





## Despliegue

No aplica





## Versionado

**Nota :** Se utiliza [SemVer](http://semver.org/) para el versionado. 
Para ver las versiones disponibles acceder a los tags del repositorio





## Autores

* **Víctor Madrid**
