package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.stereotype.Service;

import com.acme.example.archunit.archrule.rule.ServiceArchRule;
import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringServiceArchRule extends ServiceArchRule {
	
	public static final ArchRule spring_service_classes_should_be_annotated_with_service = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_REPOSITORY_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_REPOSITORY_CLASS)
		    .should().beAnnotatedWith(Service.class);
	  
}

