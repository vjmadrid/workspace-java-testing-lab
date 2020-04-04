package com.acme.example.archunit.layer;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.runner.RunWith;

import com.acme.example.archunit.user.annotation.UtilDescription;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.acme.example")
public class AssertLayerDependencyTest {

//	private JavaClasses myClasses = new ClassFileImporter()
//		    .importPackages("com.khartec");
//
//	
	@ArchTest
	public static final ArchRule util_class_definition = classes().that().resideInAPackage("..user.info").and()
			.areNotInterfaces().and().haveNameMatching(".*Util").should().beAnnotatedWith(UtilDescription.class);

	private static final Class<?>[] SUPPORTED_RETURN_TYPES = new Class<?>[] { Collections.class, Map.class };

	private static Set<Class<?>> VALID_TYPES_SET = new HashSet<>(Arrays.asList(SUPPORTED_RETURN_TYPES));

	public void check(JavaClass item, ConditionEvents events) {
		item.getMethods().stream().filter(method -> method.getName().startsWith("getNumeric"))
				.filter(method -> method.getModifiers().contains(JavaModifier.PUBLIC)).forEach(method -> {
					JavaClass returnType = method.getReturnType();
					if (!any(VALID_TYPES_SET, vrt -> returnType.isAssignableTo(vrt))) {
						String message = String.format(
								"Method %s.%s does not return a collection or map. It returns: %s", item.getName(),
								method.getName(), returnType.getName());
						events.add(SimpleConditionEvent.violated(item, message));
					}
				});
	}

	
	ArchCondition<JavaClass> findMethodsMustReturnCollectionsOrMaps = new ArchCondition<JavaClass>("..desc..") {
	
	private JavaClasses myClassesAndJavaUtilClasses = 
			   new ClassFileImporter()
			       .importPackages("com.acme", "java.util");
	

	@Test
	public void methodsPrefixedFindShouldReturnCollections() {
		ArchRule rule = classes().that().areNotInterfaces().and().haveNameMatching(".*Dao")
				.should(haveGetMethodsThatReturnCollectionsOrMaps);

		rule.check(myClassesAndJavaUtilClasses);
	}

//	@ArchTest
//	public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
//	    .layer("Controller").definedBy("test.sdc.archunit.controller..")
//	    .layer("Service").definedBy("test.sdc.archunit.service..")
//	    .layer("Adapter").definedBy("test.sdc.archunit.adapter..")
//	    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
//	    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Adapter")
//	    .whereLayer("Adapter").mayNotBeAccessedByAnyLayer();
}