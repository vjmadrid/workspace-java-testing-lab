package com.acme.example.archunit.external;

import org.junit.runner.RunWith;

import com.acme.example.archunit.external.definition.EntityArchitectureRule;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit")
public class AssertEntityArchitectureTest {
	
	@ArchTest
	public static final ArchRule entity_class_implements_serializable = EntityArchitectureRule.specific_entity_impl_serializable_architecture_validation_rule;
	
}