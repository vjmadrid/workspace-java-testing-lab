package com.acme.example.archunit.archrule.rule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMethods;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class BaseConstantArchitectureRule {
	
	@ArchTest
	public static final ArchRule constant_classes_should_be_in_constant_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_CONSTANT_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_CONSTANT_CLASS);

	@ArchTest
	public static final ArchRule constant_classes_should_have_names_ending_with_the_word_constant = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_CONSTANT_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_CONSTANT_CLASS);
	
	@ArchTest
	public static final ArchRule constant_classes_should_be_public = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_CONSTANT_CLASS)
		    .should().bePublic();
	
	@ArchTest
	public static final ArchRule constant_classes_fields_should_be_public_static_final = 
			fields().that().arePublic()
			.and().areDeclaredInClassesThat().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_CONSTANT_CLASS)
			.and().areDeclaredInClassesThat().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_CONSTANT_CLASS)
			.should().bePublic().andShould().beStatic().andShould().beFinal();
	
	@ArchTest
	public static final ArchRule constant_classes_fields_no_should_be_private = 
			noFields().that().areDeclaredInClassesThat().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_CONSTANT_CLASS)
			.and().areDeclaredInClassesThat().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_CONSTANT_CLASS)
			.should().bePrivate();
	
	@ArchTest
	public static final ArchRule constant_classes_methods_no_should_be_public = 
			noMethods().that().areDeclaredInClassesThat().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_CONSTANT_CLASS)
			.and().areDeclaredInClassesThat().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_CONSTANT_CLASS)
			.should().bePublic();

}
