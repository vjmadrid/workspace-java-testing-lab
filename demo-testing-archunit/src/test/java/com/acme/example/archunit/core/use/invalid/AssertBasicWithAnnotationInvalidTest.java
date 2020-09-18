package com.acme.example.archunit.core.use.invalid;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5
@AnalyzeClasses(packages = "com.acme.example")
public class AssertBasicWithAnnotationInvalidTest {
	
	@ArchTest
	public static ArchRule shouldBeInvalid = classes().that().resideInAPackage("..user.util").should().implement(Serializable.class);
	
}