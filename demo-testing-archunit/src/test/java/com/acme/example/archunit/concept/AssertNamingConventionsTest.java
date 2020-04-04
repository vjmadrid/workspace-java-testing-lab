package com.acme.example.archunit.concept;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit")
public class AssertNamingConventionsTest {

	private static final String FACTORY_SUFFIX = "Factory";

	@ArchTest
	public static ArchRule factory_should_be_factory_package_by_name = classes().that().haveSimpleNameContaining("UserData")
			.should().resideInAPackage("..factory");
	
	@ArchTest
	public static ArchRule factory_should_be_factory_package_by_type = classes().that().haveSimpleNameContaining("UserData")
			.should().resideInAPackage("..factory");
	
	@ArchTest
	public static ArchRule factory_should_be_example_package = classes().that().haveSimpleNameContaining("Factory")
			.should().resideInAPackage("..example.archunit..");

	@ArchTest
	public static ArchRule factory_should_be_suffixed = classes().that().resideInAPackage("..factory").should()
			.haveSimpleNameEndingWith(FACTORY_SUFFIX);

}