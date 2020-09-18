package com.acme.example.archunit.archrule.method;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.acme.example.archunit.archrule.rule.BaseExceptionArchitectureRule;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

@Disabled
public class ArchUnitBaseExceptionRulesMethodTest {
	
	private static final String PACKAGE_TEST_VALUE = "com.acme.example";

	private JavaClasses IMPORTED_CLASSES = new ClassFileImporter()
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
    		.importPackages(PACKAGE_TEST_VALUE);

	@Test
    public void shouldBeExceptionClassesShouldBeInConstantPackage() {
		BaseExceptionArchitectureRule.exception_classes_should_be_in_exception_package.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeExceptionClassesShouldHaveNamesEndingWithTheWordConstant() {
		BaseExceptionArchitectureRule.exception_classes_should_have_names_ending_with_the_word_exception.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeExceptionClassesShouldBePublic() {
		BaseExceptionArchitectureRule.exception_classes_should_be_public.check(IMPORTED_CLASSES);
    }

	
	@Test
    public void shouldBeValid() {
		assertNotNull(new BaseExceptionArchitectureRule());
    }

}