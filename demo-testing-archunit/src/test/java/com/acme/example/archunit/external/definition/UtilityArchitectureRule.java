package com.acme.example.archunit.external.definition;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class UtilityArchitectureRule {
	
	@ArchTest
	public static final ArchRule utility_classes_are_located_in_util_package = classes().that().haveSimpleNameEndingWith("Util")
			.should().resideInAPackage("..util");

	@ArchTest
	public static final ArchRule utility_methods_should_be_static = methods().that().areDeclaredInClassesThat()
			.haveSimpleNameEndingWith("Util").should().beStatic();

	
}
