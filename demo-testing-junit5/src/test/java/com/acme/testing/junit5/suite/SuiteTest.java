package com.acme.testing.junit5.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.acme.testing.junit5.core"})
public class SuiteTest {

}
