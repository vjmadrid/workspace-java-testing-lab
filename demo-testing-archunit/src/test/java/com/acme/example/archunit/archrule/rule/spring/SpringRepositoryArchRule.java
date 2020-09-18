package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.springframework.stereotype.Repository;

import com.acme.example.archunit.archrule.rule.BaseRepositoryArchitectureRule;
import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringRepositoryArchRule extends BaseRepositoryArchitectureRule {
	
	public static final ArchRule spring_repository_classes_should_be_annotated_with_repository = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_REPOSITORY_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_SPRING_REPOSITORY_CLASS)
		    .should().beAnnotatedWith(Repository.class);
	
	public static final ArchRule no_spring_repository_classes_should_be_reside_other_packages = 
			noClasses()
			.that().areAnnotatedWith(Repository.class)
		    .should().resideOutsideOfPackage(ArchUnitConstant.RESIDE_PACKAGE_SPRING_REPOSITORY_CLASS);

}
