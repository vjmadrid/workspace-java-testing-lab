package com.acme.example.archunit.concept;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

import org.junit.runner.RunWith;

import com.acme.example.archunit.user.annotation.UserDescription;
import com.acme.example.archunit.user.util.ListUtil;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example.archunit.user.entity")
public class AssertSomeClassesDefinitionAndStructureTest {

	@ArchTest
	public static final ArchRule all_entity_class_impl_serializable = classes().should().onlyBeAccessed().byClassesThat()
			.implement(Serializable.class);
	
	@ArchTest
	public static final ArchRule all_entity_class_with_annotation_filter_impl_serializable = classes().that().areAnnotatedWith(UserDescription.class).should().onlyBeAccessed().byClassesThat()
			.implement(Serializable.class);
	
	@ArchTest
	public static final ArchRule all_entity_class_with_implement_filter = 
			classes()
            .that().implement(Serializable.class)
            .should().notBe(ListUtil.class);
	

	@ArchTest
	public static final ArchRule all_entity_class_with_composition_filter = 
			classes()
            .that().areAnnotatedWith(UserDescription.class).or().haveNameMatching(".*User*")
            .should().resideInAPackage("..user..");
	
	
//
//	@ArchTest
//    public static final ArchRule the_only_class_with_high_security_is_central_core =
//            classes()
//                    .that().areAnnotatedWith(HighSecurity.class)
//                    .should().be(VeryCentralCore.class);
	
//	@ArchTest
//	public static final ArchRule all_entry_points_shoud_be_annotated_with_log_description = all(methods())
//	        .that(areDefinedInAPackage("test.sdc.archunit.controller.."))
//	        .and(arePublic())
//	        .should(beAnnotatedWith(LogDescription.class));
	
	
	
//	@ArchTest
//	public static final ArchRule entity_package_valid = theClass(User.class).should().accessClassesThat().resideOutsideOfPackages("..archunit..", "com..");
//
//	@ArchTest
//	public static final ArchRule entity_annotation_valid = theClass(User.class).should().accessClassesThat().resideOutsideOfPackages("..archunit..", "com..");
//
//	 @ArchTest
//	    public static final ArchRule the_only_class_with_high_security_is_central_core =
//	            classes()
//	                    .that().areAnnotatedWith(HighSecurity.class)
//	                    .should().be(VeryCentralCore.class);
//
//	    @ArchTest
//	    public static final ArchRule central_core_should_not_implement_some_business_interface =
//	            classes()
//	                    .that().implement(SomeOtherBusinessInterface.class)
//	                    .should().notBe(VeryCentralCore.class);

}