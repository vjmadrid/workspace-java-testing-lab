package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.springframework.stereotype.Controller;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringControllerArchRule {
	

	public static final ArchRule controller_classes_should_be_in_controller_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_CONTROLLER_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONTROLLER_CLASS);

	public static final ArchRule controller_classes_should_have_names_ending_with_the_word_controller = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONTROLLER_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_CONTROLLER_CLASS);
	
	public static final ArchRule controller_classes_should_be_annotated_with_controller = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONTROLLER_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_CONTROLLER_CLASS)
		    .should().beAnnotatedWith(Controller.class);
		    
	public static final ArchRule controller_classes_should_be_public = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONTROLLER_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_CONTROLLER_CLASS)
		    .and().areAnnotatedWith(Controller.class)
		    .should().bePublic();
	
	public static final ArchRule no_controller_classes_should_be_reside_other_packages = 
			noClasses()
			.that().areAnnotatedWith(Controller.class)
		    .should().resideOutsideOfPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_CONTROLLER_CLASS);
	
    
}
