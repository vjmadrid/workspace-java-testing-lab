package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringRestControllerArchRule {
	

	public static final ArchRule rest_controller_classes_should_be_in_restcontroller_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_REST_CONTROLLER_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_REST_CONTROLLER_CLASS);

	public static final ArchRule rest_controller_classes_should_have_names_ending_with_the_word_restcontroller = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_REST_CONTROLLER_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_REST_CONTROLLER_CLASS);
	
	public static final ArchRule rest_controller_classes_should_be_annotated_with_restcontroller = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_REST_CONTROLLER_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_REST_CONTROLLER_CLASS)
		    .should().beAnnotatedWith("RestController");
		    
	public static final ArchRule rest_controller_classes_should_be_public = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_REST_CONTROLLER_CLASS         )
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_REST_CONTROLLER_CLASS)
		    .and().areAnnotatedWith("RestController")
		    .should().bePublic();
	
//	static ArchRule rest_controller_methods_should_be_public = 
//			methods()
//		    .that().resideInAPackage("..controller..")
//		    .and().haveSimpleNameEndingWith("Controller")
//		    .and().areAnnotatedWith(RestController.class)
//		    .should().beAnnotatedWith(RequestMapping.class);
//	.orShould().beAnnotatedWith(GetMapping.class)
//    .orShould().beAnnotatedWith(PostMapping.class)
//    .orShould().beAnnotatedWith(PatchMapping.class)
//    .orShould().beAnnotatedWith(DeleteMapping.class);
		    
}
