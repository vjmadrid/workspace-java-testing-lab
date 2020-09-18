package com.acme.example.archunit.archrule.rule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class BaseExceptionArchitectureRule {
	
	@ArchTest
	public static final ArchRule exception_classes_should_be_in_exception_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_EXCEPTION_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_EXCEPTION_CLASS);

	@ArchTest
	public static final ArchRule exception_classes_should_have_names_ending_with_the_word_exception = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_EXCEPTION_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_EXCEPTION_CLASS);
	
	@ArchTest
	public static final ArchRule exception_classes_should_be_public = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_EXCEPTION_CLASS)
		    .should().bePublic();
	
}

