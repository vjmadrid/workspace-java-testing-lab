package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.TestInfo;



public class RepeatedTest {
	
	@org.junit.jupiter.api.RepeatedTest(3)
    void repeatedTest(TestInfo testInfo) {
        System.out.println("Executing repeated test :: "+testInfo);
        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }

}