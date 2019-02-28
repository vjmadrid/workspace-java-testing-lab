package com.acme.testing.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.acme.testing.junit.parametized.CalculateParametizedTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculateParametizedTest.class })
public class SuiteTest {

}
