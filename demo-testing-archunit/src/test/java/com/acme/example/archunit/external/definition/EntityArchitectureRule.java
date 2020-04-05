package com.acme.example.archunit.external.definition;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.io.Serializable;

public class EntityArchitectureRule {
	
//	@ArchTest
//    public static final ArchRule entities_must_reside_in_a_domain_package =
//            classes().that().areAnnotatedWith(Entity.class).should().resideInAPackage("..domain..")
//                    .as("Entities should reside in a package '..domain..'");
	
	@ArchTest
	public static ArchRule specific_entity_impl_serializable_architecture_validation_rule = classes().that().resideInAPackage("..user.entity").should().implement(Serializable.class);
	
}
