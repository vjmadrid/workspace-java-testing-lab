package com.acme.example.archunit.core.importclasses;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.acme.example.archunit.util.ArchUnitUtil;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;

public class ClassFileImporterTest {
	
	private static final String GENERIC_PACKAGE_TEST_VALUE = "com.acme.example";

	@Test
    public void shouldBeClassFileImporterBasic() {
		System.out.println("\n *** ClassFileImporter Basic ***");
        JavaClasses importedClasses = new ClassFileImporter().importPackages(GENERIC_PACKAGE_TEST_VALUE);
        
        //Show Code + Test Classes
        ArchUnitUtil.showInfo(importedClasses);
   
        assertTrue(Boolean.TRUE);
    }
	
	@Test
    public void shouldBeClassFileImporterClasspath() {
		System.out.println("\n *** ClassFileImporter Classpath ***");
        JavaClasses importedClasses = new ClassFileImporter().importClasspath();
        
        //Show Code + Test Classes
        ArchUnitUtil.showInfo(importedClasses);
   
        assertTrue(Boolean.TRUE);
    }

}
