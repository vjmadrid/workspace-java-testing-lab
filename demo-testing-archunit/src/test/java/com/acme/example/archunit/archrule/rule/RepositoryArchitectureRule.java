package com.acme.example.archunit.archrule.rule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class RepositoryArchitectureRule {
	
	public static final ArchRule repository_classes_should_be_in_repository_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_REPOSITORY_CLASS)
		    .should().resideInAPackage(ArchUnitConstant.SUFFIX_NAME_REPOSITORY_CLASS);

	public static final ArchRule repository_classes_should_have_names_ending_with_the_word_repository = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_REPOSITORY_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_REPOSITORY_CLASS);
	
	public static final ArchRule repository_classes_should_only_be_access = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_REPOSITORY_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_REPOSITORY_CLASS)
		    .should().onlyBeAccessed().byAnyPackage(ArchUnitConstant.RESIDE_PACKAGE_SERVICE_CLASS);
	
	static final ArchRule repository_interfaces_classes_should_not_be_placed_in_impl_packages = noClasses().that()
			.resideInAPackage("..repository.impl..").should().beInterfaces();

//	@ArchTest
//    static final ArchRule only_repositories_should_use_entityManager = noClasses()
//            .that().resideOutsideOfPackage("..repository")
//            .should().dependOnClassesThat().areAssignableTo(EntityManager.class);

}
