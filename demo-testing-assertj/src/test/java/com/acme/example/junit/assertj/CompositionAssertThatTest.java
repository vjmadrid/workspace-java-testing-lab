package com.acme.example.junit.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompositionAssertThatTest {

	private final String DEFAULT_VALUE = "test";
	
	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	
	}
	
	
	@Test
	public void shouldBeCompositionSyntaxMatcherValid() {
		List<String> testList = new ArrayList<String>();
		testList.add(DEFAULT_VALUE);
		
		//JUnit
		assertNotNull(testList);
		assertFalse(testList.isEmpty());
		
		//AssertJ 
		assertThat(testList).isNotNull().isNotEmpty();
	}

}