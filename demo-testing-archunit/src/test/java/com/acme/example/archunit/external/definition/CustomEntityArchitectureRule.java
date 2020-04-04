package com.acme.example.archunit.external.definition;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

public class CustomEntityArchitectureRule {
	
	@ArchTest
	public static ArchRule specific_entity_impl_serializable_architecture_validation_rule = classes().that().resideInAPackage("..user.entity").should().implement(Serializable.class);
	
}
