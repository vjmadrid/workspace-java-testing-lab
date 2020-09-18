package com.acme.example.archunit.archrule.rule.spring;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.stereotype.Repository;

import com.acme.example.archunit.archrule.rule.RepositoryArchitectureRule;
import com.acme.example.archunit.constant.ArchUnitConstant;
import com.tngtech.archunit.lang.ArchRule;

public class SpringRepositoryArchRule extends RepositoryArchitectureRule {
	
	public static final ArchRule spring_repository_classes_should_be_annotated_with_repository = 
		    classes()
		    .that().resideInAPackage(ArchUnitConstant.RESIDE_PACKAGE_REPOSITORY_CLASS)
		    .and().haveSimpleNameEndingWith(ArchUnitConstant.SUFFIX_NAME_REPOSITORY_CLASS)
		    .should().beAnnotatedWith(Repository.class);

}
