package com.acme.example.archunit.core.importclasses;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.acme.example.archunit.user.entity.User;
import com.acme.example.archunit.util.ArchUnitUtil;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;


public class ClassFileImporterWithConfigTest {
	
	private static final String GENERIC_PACKAGE_TEST_VALUE = "com.acme.example";
	private static final String USER_PACKAGE_TEST_VALUE = "com.acme.example.archunit.user";
	
	@Test
    public void shouldBeClassFileImporterWithConfiguration() {
		System.out.println("\n*** ClassFileImporterWithConfig With Configuration ***");
        JavaClasses importedClasses = new ClassFileImporter()
        		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
        		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
        		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
        		.importPackages(GENERIC_PACKAGE_TEST_VALUE);
        
      //Show Code
        ArchUnitUtil.showInfo(importedClasses);
   
        assertTrue(Boolean.TRUE);
    }
	
	@Test
    public void shouldBeClassFileImporterWithUserPackage() {
		System.out.println("\n *** ClassFileImporterWithConfig with User Package ***");
		JavaClasses importedClasses = new ClassFileImporter()
        		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
        		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
        		.importPackages(USER_PACKAGE_TEST_VALUE);

        //Show Code
        ArchUnitUtil.showInfo(importedClasses);
        
        assertTrue(Boolean.TRUE);
    }
	
	@Test
    public void shouldBeClassFileImporterShowClassUserPackage() {
		System.out.println("\n *** ClassFileImporterWithConfig show class User Package ***");
		JavaClasses importedClasses = new ClassFileImporter()
        		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
        		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
        		.importPackages(USER_PACKAGE_TEST_VALUE);

        System.out.println("Get Class info");
        JavaClass clazz = importedClasses.get(User.class);
        System.out.print("User Class :: "+ clazz.getFullName());
   
        assertTrue(Boolean.TRUE);
    }

}
