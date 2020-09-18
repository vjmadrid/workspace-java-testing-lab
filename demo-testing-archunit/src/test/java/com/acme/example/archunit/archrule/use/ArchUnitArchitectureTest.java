package com.acme.example.archunit.archrule.use;

import com.acme.example.archunit.archrule.rule.BaseConstantArchitectureRule;
import com.acme.example.archunit.archrule.rule.BaseExceptionArchitectureRule;
import com.acme.example.archunit.archrule.rule.BaseUtilArchitectureRule;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;

@AnalyzeClasses(packages = "com.acme.example", 
importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeArchives.class })
public class ArchUnitArchitectureTest {
	
	@ArchTest
	public static final ArchRules base_constant_architecture = ArchRules.in(BaseConstantArchitectureRule.class);
	
	@ArchTest
	public static final ArchRules base_exception_architecture = ArchRules.in(BaseExceptionArchitectureRule.class);
	
	@ArchTest
	public static final ArchRules base_util_architecture = ArchRules.in(BaseUtilArchitectureRule.class);
	
}
