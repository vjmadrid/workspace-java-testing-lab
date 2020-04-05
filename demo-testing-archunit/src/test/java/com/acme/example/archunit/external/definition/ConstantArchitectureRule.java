package com.acme.example.archunit.external.definition;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

public class ConstantArchitectureRule {
	
	@ArchTest
    public static final ArchRule entity_class_implements_serializable = (ArchRule) classes().that().resideInAPackage("..entity").should().implement(Serializable.class);

	
	
}
