package com.acme.example.archunit.core.use.basic;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5∂
@AnalyzeClasses(packages = "com.acme.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
public class AssertNoClassesTest {

	@ArchTest
	static ArchRule classes_must_not_be_suffixed_with_impl = 
    noClasses()
    .should().haveSimpleNameEndingWith("Impl")
    .because("seriously, you can do better than that");

}