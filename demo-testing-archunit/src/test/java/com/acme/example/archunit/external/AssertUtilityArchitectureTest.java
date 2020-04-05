package com.acme.example.archunit.external;

import org.junit.runner.RunWith;

import com.acme.example.archunit.external.definition.UtilityArchitectureRule;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit")
public class AssertUtilityArchitectureTest {
	
	@ArchTest
	public static final ArchRule utility_classes_are_located_in_util_package = UtilityArchitectureRule.utility_classes_are_located_in_util_package;
	
	@ArchTest
	public static final ArchRule utility_methods_should_be_static = UtilityArchitectureRule.utility_methods_should_be_static;
	
}