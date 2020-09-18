package com.acme.example.archunit.core.use.basic;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

import com.acme.example.archunit.user.util.ListUtil;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

//@RunWith(ArchUnitRunner.class) //Only for JUnit 4 , not needed JUnit5∂
@AnalyzeClasses(packages = "com.acme.example", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class })
public class AssertFieldsTest {

	@ArchTest
	private final ArchRule utility_class_should_be_private_static_final = fields().that().haveRawType(ListUtil.class)
			.should().bePrivate().andShould().beStatic().andShould().beFinal();

}