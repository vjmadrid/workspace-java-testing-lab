package com.acme.testing.junit5.core.parameterinjection;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RandomUUIDParameterResolver.class)
public class ParameterInjectionTest {

	@RepeatedTest(4)
	public void testMethodName(TestInfo testInfo, TestReporter testReporter, RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getTestMethod().get().getName());
		testReporter.publishEntry("custom-message", "ACME");
		System.out.println(repetitionInfo.getCurrentRepetition() + " from " + repetitionInfo.getTotalRepetitions());
	}

	@RepeatedTest(4)
	public void testUUIDInjection(@RandomUUID String uuid) {
		System.out.println("Random UUID: " + uuid);
	}
}
