package com.acme.testing.junit5.core.assumption;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

public class AssumptionTest {

	@Test
	void testOnlyOnDev() {
	    assumeTrue("dev".equals(System.getenv("profile")));
	    // the following lines will only be executed if profile equals dev
	}
	@Test
	void testOnlyOnLocalMachine() {
	    assumeTrue("local".equals(System.getenv("profile")));
	    // the following lines will only be executed if profile equals local
	}
	@Test
	void testEveryWhere() {
	    assumingThat("local".equals(System.getenv("profile")),
	            () -> {
	                // this code will only be executed on the local profile
	            });
	    // this assertion will always be executed
	    assertTrue(true);
	}

}