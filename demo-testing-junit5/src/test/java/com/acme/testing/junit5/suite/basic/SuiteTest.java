package com.acme.testing.junit5.suite.basic;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit 5 Suite Test Name")
@SelectPackages({"com.acme.testing.junit5.core.basic"})
//@UseTechnicalNames
public class SuiteTest {

}
