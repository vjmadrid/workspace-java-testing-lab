package com.acme.testing.junit5.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;



public class RepeatedExampleTest {
	
	@BeforeEach
    public void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		//Show info
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        
        System.out.println(String.format("[SETUP] About to execute repetition %d of %d for %s", //
                currentRepetition, totalRepetitions, methodName));
    }
	
	//No require info setUp
	@RepeatedTest(3)
    void shouldBeRepeatedTest3times(TestInfo testInfo) {
		System.out.println("[@Test] : shouldBeRepeatedTest3times :: "+testInfo);

        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }
	
	//No require info setUp
	@RepeatedTest(5)
	void shouldBeRepeatedTest5times(RepetitionInfo repetitionInfo) {
	    System.out.println("[@Test] : shouldBeRepeatedTest5times repetition " + repetitionInfo.getCurrentRepetition() + " out of " + repetitionInfo.getTotalRepetitions());
	  
	    assertEquals(5, repetitionInfo.getTotalRepetitions());
	}
	
	//No require info setUp
	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    public void shouldBeRepeatedTest2times(TestInfo testInfo) {
		System.out.println("[@Test] : shouldBeRepeatedTest2times :: "+testInfo);
		
		//when use value = 2 then fail because equal expected 1/1 and value es 1/2
		
        assertEquals("Repeat! 1/1", testInfo.getDisplayName());
    }
	
	//No require info setUp
	@RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    public void shouldBeRepeatedTest4times(TestInfo testInfo) {
		System.out.println("[@Test] : shouldBeRepeatedTest4times :: "+testInfo);
		
		//when use value != 1 then fail because equal expected 1/1 and value es 1/X
		
        assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
    }

}