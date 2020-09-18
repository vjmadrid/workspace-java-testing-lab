package com.acme.example.archunit.archrule.rule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class UtilArchitectureRule {
	
	public static final ArchRule util_classes_should_be_in_util_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_UTIL_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_UTIL_CLASS);

	public static final ArchRule util_classes_should_have_names_ending_with_the_word_util = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_UTIL_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_UTIL_CLASS);

	public static final ArchRule util_classes_should_be_public = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_UTIL_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_UTIL_CLASS)
		    .should().bePublic();
	
	public static final ArchRule util_classes_methods_should_be_static = methods().that().arePublic()
			.and().areDeclaredInClassesThat().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_UTIL_CLASS)
			.and().areDeclaredInClassesThat().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_UTIL_CLASS)
			.should().beStatic();
	
}
