package com.acme.example.archunit.concept;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit")
public class AssertNoDependTest {

	@ArchTest
	public static final ArchRule util_class_no_depend_other_util = classes()
			.matching("test.sdc.archunit.(adapter).(*)..").namingSlices("$1 '$2'")
		    .ignoreDependency("test.sdc.archunit.adapter.*..", "test.sdc.archunit.adapter.common..")
		     .should().notDependOnEachOther();
	
}