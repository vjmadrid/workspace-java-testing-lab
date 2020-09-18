package com.acme.example.archunit.core.use;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import com.acme.example.archunit.archrule.rule.BaseEntityArchitectureRule;
import com.acme.example.archunit.util.ArchUnitUtil;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

public class AssertMethodTest {
	
	private static final String PACKAGE_TEST_VALUE = "com.acme.example";

	private JavaClasses IMPORTED_CLASSES = new ClassFileImporter()
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
    		.importPackages(PACKAGE_TEST_VALUE);
	
	
	@Test
    public void shouldBeValid() {
		// Rule entities_impl_serializable
        ArchRule rule = classes().that().resideInAPackage("..archunit.entity").should().implement(Serializable.class);

        System.out.println("\n*** VALID :: "+rule+" ****");
        
        ArchUnitUtil.showInfo(IMPORTED_CLASSES);
        
        rule.check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeValid2() {
		// Rule entities_impl_serializable
        classes().that().resideInAPackage("..archunit.entity").should().implement(Serializable.class).check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeValid3() {
		// Rule entities_impl_serializable
		ArchRuleDefinition.classes().that().resideInAPackage("..archunit.entity").should().implement(Serializable.class).check(IMPORTED_CLASSES);
    }
	
	@Test
    public void shouldBeValid4() {
		// Rule entities_impl_serializable
        ArchRule rule = BaseEntityArchitectureRule.entity_classes_should_be_in_entity_package;

        System.out.println("\n*** VALID :: "+rule+" ****");
        
        ArchUnitUtil.showInfo(IMPORTED_CLASSES);
        
        rule.check(IMPORTED_CLASSES);
    }
	
	
}