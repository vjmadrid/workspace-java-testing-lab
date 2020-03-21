package com.acme.example.junit.assertj.matcher.core;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BooleanMatchersTest {
	
	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldBeBooleanMatcher() {
		//JUnit
		assertTrue("".isEmpty());
		
		//AssertJ
		assertThat("".isEmpty()).isTrue();
	}
	
	
}