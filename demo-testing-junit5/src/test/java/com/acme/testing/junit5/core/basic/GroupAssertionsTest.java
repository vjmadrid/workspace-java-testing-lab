package com.acme.testing.junit5.core.basic;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GroupAssertionsTest {

	@Test
	void shouldBeStandarAssertions() {
		assertEquals(2, 1 + 1);
        assertEquals(3, 1 + 2);
        assertEquals(4, 2 + 2);
	}
	
	@Test
	void shouldBeGroupedAssertions() {
	    assertAll("calculator",
	            () -> assertEquals(2, 1 + 1),
	            () -> assertEquals(3, 1 + 2),
	            () -> assertEquals(4, 2 + 2)
	    );
	}
	
	@Test
	void shouldBeDependentAssertions() {
	    assertAll("dependent",
	            () -> {
	            	
	            	assertEquals(0, 0 + 0);
	            	
	            	assertAll("add",
	        	            () -> assertEquals(2, 1 + 1),
	        	            () -> assertEquals(3, 1 + 2),
	        	            () -> assertEquals(4, 2 + 2)
	        	    );
	            },
	            () -> {
	            	
	            	assertEquals(0, 0 - 0);
	            
	            	assertAll("subtraction",
	        	            () -> assertEquals(0, 1 - 1),
	        	            () -> assertEquals(-1, 1 - 2),
	        	            () -> assertEquals(0, 2 - 2)
	        	    );
	            	
	            }
	    );
	}

}