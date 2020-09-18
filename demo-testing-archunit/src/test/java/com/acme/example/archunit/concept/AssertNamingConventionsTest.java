package com.acme.example.archunit.concept;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5
@AnalyzeClasses(packages = "com.acme.example.archunit", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
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