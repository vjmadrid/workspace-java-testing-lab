package com.acme.example.archunit.core.use.invalid;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import com.acme.example.archunit.util.ArchUnitUtil;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class AssertBasicWithMethodInvalidTest {
	
	private static final String PACKAGE_TEST_VALUE = "com.acme.example";

	@Test
    public void shouldBeInvalid() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(PACKAGE_TEST_VALUE);
    
        ArchRule rule = classes().that().resideInAPackage("..user.util").should().implement(Serializable.class);
        
        System.out.println("\n*** INVALID :: "+rule+" ****");
        
        ArchUnitUtil.showInfo(importedClasses);
        
        //CASE 1
        //rule.check(importedClasses);
        
        //CASE 2
        //assertThrows(AssertionError.class, ()-> rule.check(importedClasses));
        
        AssertionError exception = assertThrows(AssertionError.class, ()->{
        	rule.check(importedClasses);
		});
		
        //CASE 3
		assertEquals("Architecture Violation [Priority: MEDIUM] - Rule 'classes that reside in a package '..user.util' should implement java.io.Serializable' was violated (1 times):\n" + 
				"Class <com.acme.example.archunit.user.util.ListUtil> does not implement java.io.Serializable in (ListUtil.java:0)", exception.getMessage());
    }
	
}