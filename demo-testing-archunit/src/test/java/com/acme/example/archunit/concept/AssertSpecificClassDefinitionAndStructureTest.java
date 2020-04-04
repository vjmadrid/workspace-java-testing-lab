package com.acme.example.archunit.concept;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.theClass;

import java.io.Serializable;

import org.junit.runner.RunWith;

import com.acme.example.archunit.user.annotation.UserDescription;
import com.acme.example.archunit.user.entity.User;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit.user.entity")
public class AssertSpecificClassDefinitionAndStructureTest {

	@ArchTest
	public static final ArchRule user_entity_class_access_package = theClass(User.class).should().accessClassesThat().resideOutsideOfPackages("..archunit..", "com..");
	
	@ArchTest
	public static final ArchRule user_entity_class_package_validation = theClass(User.class).should().resideInAPackage("..entity");
	
	@ArchTest
	public static final ArchRule user_entity_class_impl_serializable = theClass(User.class).should().onlyBeAccessed().byClassesThat()
			.implement(Serializable.class);
	
	@ArchTest
	public static final ArchRule user_entity_class_use_annotation_UserDescription = theClass(User.class).should().beAnnotatedWith(UserDescription.class);

}