package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.stereotype.Component;

import com.acme.example.archunit.archrule.rule.BaseEntityArchitectureRule;
import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringEntityArchitectureRule extends BaseEntityArchitectureRule{
	

	public static final ArchRule spring_entity_classes_should_be_in_entity_package = 
			classes()
		    .that().resideInAPackage(ArchUnitConstant.SUFFIX_NAME_SPRING_ENTITY_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.RESIDE_PACKAGE_SPRING_ENTITY_CLASS)
		    .should().beAnnotatedWith(Component.class);
	
}





