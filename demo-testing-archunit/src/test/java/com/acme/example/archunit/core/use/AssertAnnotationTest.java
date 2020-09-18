package com.acme.example.archunit.core.use;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

import com.acme.example.archunit.archrule.rule.BaseEntityArchitectureRule;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5∂
@AnalyzeClasses(packages = "com.acme.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeArchives.class })
public class AssertAnnotationTest {
	
	@ArchTest
	public static ArchRule shouldBeValid = classes().that().resideInAPackage("..archunit.entity").should().implement(Serializable.class);
	
	@ArchTest
	public static ArchRule shouldBeValid2 = BaseEntityArchitectureRule.entity_classes_should_be_in_entity_package;
	
}