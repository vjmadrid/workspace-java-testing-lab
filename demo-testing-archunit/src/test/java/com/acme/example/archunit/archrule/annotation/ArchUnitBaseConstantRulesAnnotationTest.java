package com.acme.example.archunit.archrule.annotation;

import org.junit.jupiter.api.Disabled;

import com.acme.example.archunit.archrule.rule.BaseConstantArchitectureRule;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@Disabled
@AnalyzeClasses(packages = "com.cistec.tech.architecture.testing", 
importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeArchives.class })
public class ArchUnitBaseConstantRulesAnnotationTest {

	@ArchTest
	public static final ArchRule constant_classes_should_be_in_constant_package = BaseConstantArchitectureRule.constant_classes_should_be_in_constant_package;
	
	@ArchTest
	public static final ArchRule constant_classes_should_have_names_ending_with_the_word_constant = BaseConstantArchitectureRule.constant_classes_should_have_names_ending_with_the_word_constant;
	
	@ArchTest
	public static final ArchRule constant_classes_should_be_public = BaseConstantArchitectureRule.constant_classes_should_be_public;
	
	@ArchTest
	public static final ArchRule constant_classes_fields_should_be_public_static_final = BaseConstantArchitectureRule.constant_classes_fields_should_be_public_static_final;
	
	@ArchTest
	public static final ArchRule constant_classes_fields_no_should_be_private = BaseConstantArchitectureRule.constant_classes_fields_no_should_be_private;
	
	@ArchTest
	public static final ArchRule constant_classes_methods_no_should_be_public = BaseConstantArchitectureRule.constant_classes_methods_no_should_be_public;
	
}