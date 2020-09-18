package com.acme.example.archunit.archrule.method;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.acme.example.archunit.archrule.rule.BaseConstantArchitectureRule;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

@Disabled
public class ArchUnitBaseConstantRulesMethodTest {
	
	private static final String PACKAGE_TEST_VALUE = "com.acme.example";

	private JavaClasses IMPORTED_CLASSES = new ClassFileImporter()
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
    		.importPackages(PACKAGE_TEST_VALUE);

	@Test
    public void shouldBeConstantClassesShouldBeInConstantPackage() {
        BaseConstantArchitectureRule.constant_classes_should_be_in_constant_package.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeConstantClassesShouldHaveNamesEndingWithTheWordConstant() {
        BaseConstantArchitectureRule.constant_classes_should_have_names_ending_with_the_word_constant.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeConstantClassesShouldBePublic() {
        BaseConstantArchitectureRule.constant_classes_should_be_public.check(IMPORTED_CLASSES);
    }

	@Test
    public void shouldBeConstantClassesFieldsShouldBePublicStaticFinal() {
        BaseConstantArchitectureRule.constant_classes_fields_should_be_public_static_final.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeConstantConstantClassesFieldsNoShouldBePrivate() {
        BaseConstantArchitectureRule.constant_classes_fields_no_should_be_private.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeConstantClassesMethodsNoShouldBePublic() {
        BaseConstantArchitectureRule.constant_classes_methods_no_should_be_public.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeValid() {
		assertNotNull(new BaseConstantArchitectureRule());
    }

}
