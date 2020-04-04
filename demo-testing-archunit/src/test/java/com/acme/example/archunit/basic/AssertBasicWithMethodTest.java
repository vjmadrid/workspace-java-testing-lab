package com.acme.example.archunit.basic;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class AssertBasicWithMethodTest {
	
	private static final String PACKAGE_TEST_VALUE = "com.acme";

	//private JavaClasses IMPORTED_CLASSES = new ClassFileImporter().importPackages(PACKAGE_TEST_VALUE);
	    
	
	@Test
    public void base_entity_impl_serializable_architecture_validation_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(PACKAGE_TEST_VALUE);
    
        ArchRule rule = classes().that().resideInAPackage("..archunit.entity").should().implement(Serializable.class);
        // Test create class : UserNoImplement
        
        rule.check(importedClasses);
    }
	
	@Test
    public void specific_entity_impl_serializable_architecture_validation_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(PACKAGE_TEST_VALUE);
    
        ArchRule rule = classes().that().resideInAPackage("..user.entity").should().implement(Serializable.class);
        // Test create class : UserNoImplement
        
        rule.check(importedClasses);
    }
	
}