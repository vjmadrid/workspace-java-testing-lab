package com.acme.example.archunit.concept;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit")
public class AssertSpecificClassVarTest {

	@ArchTest
	public static final ArchRule check_control_validation = noClasses()
	        .that().resideOutsideOfPackage("com.acme.example.archunit.user..")
	        .should().accessClassesThat().resideInAnyPackage("com.acme.example.archunit.user.util");

}