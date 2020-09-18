package com.acme.example.archunit.archrule.rule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class ServiceArchRule {
	
	public static final ArchRule service_classes_should_be_in_service_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SERVICE_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.SUFFIX_NAME_SERVICE_CLASS);

	public static final ArchRule service_classes_should_have_names_ending_with_the_word_service = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.SUFFIX_NAME_SERVICE_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SERVICE_CLASS);
	
	public static final ArchRule service_classes_should_only_be_access = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.SUFFIX_NAME_SERVICE_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SERVICE_CLASS)
		    .should().onlyBeAccessed().byAnyPackage(ArchUnitConstant.SUFFIX_NAME_SERVICE_CLASS, ArchUnitConstant.SUFFIX_NAME_REPOSITORY_CLASS);
		   
}

