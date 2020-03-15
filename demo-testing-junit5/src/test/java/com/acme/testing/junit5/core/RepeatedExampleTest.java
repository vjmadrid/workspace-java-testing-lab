package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;



public class RepeatedExampleTest {
	
	@BeforeEach
    public void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        
        System.out.println(String.format("[SETUP] About to execute repetition %d of %d for %s", //
                currentRepetition, totalRepetitions, methodName));
    }
	
//	@RepeatedTest(3)
//    void repeatedTest(TestInfo testInfo) {
//        System.out.println("Executing repeated test :: "+testInfo);
//        
//        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
//    }
	
//	@RepeatedTest(10)
//	void testRepetition(RepetitionInfo repetitionInfo) {
//	    System.out.println("Repetition " + repetitionInfo.getCurrentRepetition() + " out of " + repetitionInfo.getTotalRepetitions());
//	  
//	    assertEquals(10, repetitionInfo.getTotalRepetitions());
//	}
	
	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    public void customDisplayName(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Repeat! 1/1");
    }
	
	@RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    public void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Details... :: repetition 1 of 1");
    }

}