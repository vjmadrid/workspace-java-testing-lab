package com.acme.example.archunit.basic;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5
@AnalyzeClasses(packages = "com.acme.example.archunit")
public class AssertBasicWithAnnotationTest {
	
	@ArchTest
	public static ArchRule base_entity_impl_serializable_architecture_validation_rule = classes().that().resideInAPackage("..archunit.entity").should().implement(Serializable.class);
	
	@ArchTest
	public static ArchRule specific_entity_impl_serializable_architecture_validation_rule = classes().that().resideInAPackage("..user.entity").should().implement(Serializable.class);
	
}