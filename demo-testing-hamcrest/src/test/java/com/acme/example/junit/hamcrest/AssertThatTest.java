package com.acme.example.junit.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
	public void shouldBeExactMatch() {
		//JUnit
		assertEquals(DEFAULT_VALUE, testValue);
		
		//Hamcrest (todos los assertThat hacen lo mismo)
		assertThat(testValue, equalTo(DEFAULT_VALUE));
		assertThat(testValue, is(DEFAULT_VALUE));
		assertThat(testValue, is(equalTo(DEFAULT_VALUE)));
	}
	
	@Test
	public void shouldBePartialMatch() {
		//JUnit 
		assertFalse(OTHER_VALUE.equals(testValue));
		
		//Hamcrest (todos los assertThat hacen lo mismo)
		assertThat(testValue, not(equalTo(OTHER_VALUE)));
		assertThat(testValue, is(not(OTHER_VALUE)));
		assertThat(testValue, is(not(equalTo(OTHER_VALUE))));
	}
	
	

}