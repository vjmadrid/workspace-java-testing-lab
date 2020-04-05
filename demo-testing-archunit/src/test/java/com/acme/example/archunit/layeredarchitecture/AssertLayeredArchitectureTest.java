package com.acme.example.archunit.layeredarchitecture;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;

public class AssertLayeredArchitectureTest {
	
	private static final String PACKAGE_BASE = "com.acme.example.archunit.user";
	
	private final JavaClasses classes = new ClassFileImporter().importPackages(PACKAGE_BASE);

	@Test
    public void layer_dependencies_are_respected() {
        layeredArchitecture()

        		.layer("Repositories").definedBy(PACKAGE_BASE+".repository")
        		.layer("Services").definedBy(PACKAGE_BASE+".service")
                .layer("Controllers").definedBy(PACKAGE_BASE+".controller")

                .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Services")
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                
                .check(classes);
    }
	
}