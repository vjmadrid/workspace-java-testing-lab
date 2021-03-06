package com.acme.example.archunit.core.use.basic;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.theClass;

import java.io.Serializable;

import com.acme.example.archunit.user.annotation.UserDescription;
import com.acme.example.archunit.user.entity.User;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5∂
@AnalyzeClasses(packages = "com.acme.example.archunit.user.entity", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
public class AssertTheClassTest {

	@ArchTest
	public static final ArchRule entity_class_access_package = theClass(User.class).should().accessClassesThat().resideOutsideOfPackages("..archunit..", "com..");
	
	@ArchTest
	public static final ArchRule entity_class_package_validation = theClass(User.class).should().resideInAPackage("..entity");
	
	@ArchTest
	public static final ArchRule entity_class_impl_serializable = theClass(User.class).should().onlyBeAccessed().byClassesThat()
			.implement(Serializable.class);
	
	@ArchTest
	public static final ArchRule entity_class_use_annotation_UserDescription = theClass(User.class).should().beAnnotatedWith(UserDescription.class);

}