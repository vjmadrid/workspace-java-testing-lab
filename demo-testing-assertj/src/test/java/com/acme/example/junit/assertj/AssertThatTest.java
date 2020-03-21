package com.acme.example.junit.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssertThatTest {

	private String DEFAULT_VALUE = "test";
	
	private String OTHER_VALUE = "other test";
	
	private String testValue;
	
	@Before
	public void setUp() {
		testValue = DEFAULT_VALUE;	
	}

	@After
	public void tearDown() {
	
	}

	@Test
	public void shouldBeEqualsToWithDifferentSyntaxMatch() {
		//JUnit
		assertEquals(DEFAULT_VALUE, testValue);
		
		//AssertJ 
		assertThat(testValue).isEqualTo(DEFAULT_VALUE);                 
	}
	
	@Test
	public void shouldBeEqualsToMessageWithDifferentSyntaxMatch() {
		//JUnit
		assertEquals("Custom Assertion Description", DEFAULT_VALUE, testValue);
		
		//AssertJ 
		assertThat(testValue).as("Custom Assertion Description").isEqualTo(DEFAULT_VALUE);
	}

}