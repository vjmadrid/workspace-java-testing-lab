package com.acme.example.archunit.archrule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

import com.tngtech.archunit.lang.ArchRule;

public class ExampleArchRule {
	
	public static final ArchRule entities_implements_serializable = classes().that().resideInAPackage("..archunit.entity").should().implement(Serializable.class);
	
}
