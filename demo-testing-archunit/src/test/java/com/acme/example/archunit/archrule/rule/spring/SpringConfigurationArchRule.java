package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.springframework.context.annotation.Configuration;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringConfigurationArchRule {
	
	public static final ArchRule spring_configuration_classes_should_be_in_config_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_CONFIG_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONFIG_CLASS);
	
	public static final ArchRule spring_configuration_classes_should_have_names_ending_with_the_word_config = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.SUFFIX_NAME_SPRING_CONFIG_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_ENTITY_CLASS);
	
	public static final ArchRule spring_configuration_classes_should_be_annotated_with_configuration = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONFIG_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_CONFIG_CLASS)
		    .should().beAnnotatedWith(Configuration.class);
	
	public static final ArchRule no_spring_configuration_classes_should_be_reside_other_packages = 
			noClasses()
			.that().areAnnotatedWith(Configuration.class)
		    .should().resideOutsideOfPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONFIG_CLASS);
	  
}

