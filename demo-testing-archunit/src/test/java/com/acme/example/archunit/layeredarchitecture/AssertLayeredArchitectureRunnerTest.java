package com.acme.example.archunit.layeredarchitecture;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example")
public class AssertLayeredArchitectureRunnerTest {
	
	private static final String PACKAGE_BASE = "com.acme.example.archunit.user";
	
	@ArchTest
	public static final ArchRule layer_dependencies_validation = layeredArchitecture()

			.layer("Entities").definedBy(PACKAGE_BASE+".entity")
			.layer("Factories").definedBy(PACKAGE_BASE+".factory")
			.layer("Utils").definedBy(PACKAGE_BASE+".util")

			.whereLayer("Entities").mayOnlyBeAccessedByLayers("Factories")
			.whereLayer("Factories").mayOnlyBeAccessedByLayers("Utils");

//	@ArchTest
//    public static final ArchRule layer_dependencies_are_respected_with_exception = layeredArchitecture()
//
//    		.layer("Repositories").definedBy(PACKAGE_BASE+".repository")
//    		.layer("Services").definedBy(PACKAGE_BASE+".service")
//            .layer("Controllers").definedBy(PACKAGE_BASE+".controller")
//            
//            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services")
//            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
//            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer();
//         
//            //.ignoreDependency(Example1.class, Example2.class);
	
}