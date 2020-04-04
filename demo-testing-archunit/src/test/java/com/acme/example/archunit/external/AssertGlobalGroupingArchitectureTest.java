package com.acme.example.archunit.external;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit")
public class AssertGlobalGroupingArchitectureTest {
	
	@ArchTest
	public static final ArchRules global_architecture = ArchRules.in(AssertEntityArchitectureTest.class);
	
	
}