package com.acme.example.archunit.core.use.basic;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5∂
@AnalyzeClasses(packages = "com.acme.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
public class AssertClassesTest {

	@ArchTest
	private final ArchRule utility_classes_are_located_in_util_package = classes().that().haveSimpleNameEndingWith("Util")
			.should().resideInAPackage("..util");

}