package com.acme.example.archunit.basic.classes;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

import org.junit.runner.RunWith;

import com.acme.example.archunit.user.util.ListUtil;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example")
public class AssertUtilTypeClassesDefinitionAndStructureTest {

	@ArchTest
	private final ArchRule utility_classes_are_located_in_util_package = classes().that().haveSimpleNameEndingWith("Util")
			.should().resideInAPackage("..util");

	@ArchTest
	private final ArchRule utility_class_should_be_private_static_final = fields().that().haveRawType(ListUtil.class)
			.should().bePrivate().andShould().beStatic().andShould().beFinal();

	@ArchTest
	static final ArchRule utility_methods_should_be_static = methods().that().areDeclaredInClassesThat()
			.haveSimpleNameEndingWith("Util").should().beStatic();

}