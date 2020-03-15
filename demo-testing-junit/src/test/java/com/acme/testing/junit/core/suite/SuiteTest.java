package com.acme.testing.junit.core.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.acme.testing.junit.core.parameterized.CalculateParameterizedTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculateParameterizedTest.class })
public class SuiteTest {

}
