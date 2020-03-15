package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GroupAssertionsTest {

	@Test
	void groupAssertionsExample() {
		assertEquals(2, 1 + 1);
        assertEquals(3, 1 + 2);
        assertEquals(4, 2 + 2);
	}
	
	@Test
	void groupAssertionsExampleWithLambdas() {
	    assertAll("calculator",
	            () -> assertEquals(2, 1 + 1),
	            () -> assertEquals(3, 1 + 2),
	            () -> assertEquals(4, 2 + 2)
	    );
	}

}