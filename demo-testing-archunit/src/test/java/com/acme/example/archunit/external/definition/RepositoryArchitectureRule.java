package com.acme.example.archunit.external.definition;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class RepositoryArchitectureRule {

	@ArchTest
	public static final ArchRule repository_classes_are_located_in_util_package = classes().that()
			.haveSimpleNameEndingWith("Repository").should().resideInAPackage("..repository");

	@ArchTest
	static final ArchRule interfaces_should_not_be_placed_in_impl_packages = noClasses().that()
			.resideInAPackage("..repository.impl..").should().beInterfaces();

	@ArchTest
	private final ArchRule no_generic_exceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

	@ArchTest
	public static final ArchRule repository_must_reside_in_a_repository_package = classes().that().haveNameMatching(".*Dao").should()
			.resideInAPackage("..repository..").as("Repositories should reside in a package '..repository..'");

//	@ArchTest
//    static final ArchRule only_repositories_should_use_entityManager = noClasses()
//            .that().resideOutsideOfPackage("..repository")
//            .should().dependOnClassesThat().areAssignableTo(EntityManager.class);

}
