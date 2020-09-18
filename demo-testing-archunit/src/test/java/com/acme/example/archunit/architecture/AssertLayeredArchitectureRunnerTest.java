package com.acme.example.archunit.architecture;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5∂
@AnalyzeClasses(packages = "com.acme.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
public class AssertLayeredArchitectureRunnerTest {
	
	@ArchTest
	static ArchRule layeredArchitecture = 
	    layeredArchitecture()
	    .layer("Entity").definedBy("..entity..")
	    .layer("Repository").definedBy("..repository..")
	    .layer("Domain").definedBy("..domain..")
	    .layer("Service").definedBy("..service..")
	    .layer("DTO").definedBy("..dto..")
	    .layer("Controller").definedBy("..controller..")

	    .whereLayer("DTO").mayOnlyBeAccessedByLayers("Controller")
	    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
	    .whereLayer("Domain").mayOnlyBeAccessedByLayers("Controller", "Service")
	    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
	    .whereLayer("Entity").mayOnlyBeAccessedByLayers("Repository", "Service");
	
}