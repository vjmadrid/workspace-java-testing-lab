package com.acme.example.archunit.archrule.use;

import com.acme.example.archunit.archrule.rule.EntityArchitectureRule;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5
@AnalyzeClasses(packages = "com.acme.example.archunit", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
public class AssertEntityArchitectureTest {
	
	@ArchTest
	public static final ArchRule entity_classes_should_be_in_entity_package = EntityArchitectureRule.entity_classes_should_be_in_entity_package;
	
}