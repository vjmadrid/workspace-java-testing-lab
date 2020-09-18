package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.springframework.stereotype.Service;

import com.acme.example.archunit.archrule.rule.BaseServiceArchRule;
import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringServiceArchRule extends BaseServiceArchRule {
	
	public static final ArchRule spring_service_classes_should_be_annotated_with_service = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_SERVICE_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_SERVICE_CLASS)
		    .should().beAnnotatedWith(Service.class);
	
	public static final ArchRule no_spring_service_classes_should_be_reside_other_packages = 
			noClasses()
			.that().areAnnotatedWith(Service.class)
		    .should().resideOutsideOfPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_SERVICE_CLASS);

}

