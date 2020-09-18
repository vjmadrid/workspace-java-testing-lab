package com.acme.example.archunit.archrule;

import org.junit.jupiter.api.Test;

import com.acme.example.archunit.util.ArchUnitUtil;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;

public class AssertMethodWithRuleTest {
	
	private static final String PACKAGE_TEST_VALUE = "com.acme.example";

	private JavaClasses IMPORTED_CLASSES = new ClassFileImporter()
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
    		.importPackages(PACKAGE_TEST_VALUE);
	
	@Test
    public void shouldBeValid() {
		// Rule entities_impl_serializable
        ArchRule rule = ExampleArchRule.entities_implements_serializable;

        System.out.println("\n*** VALID :: "+rule+" ****");
        
        ArchUnitUtil.showInfo(IMPORTED_CLASSES);
        
        rule.check(IMPORTED_CLASSES);
    }
	
}