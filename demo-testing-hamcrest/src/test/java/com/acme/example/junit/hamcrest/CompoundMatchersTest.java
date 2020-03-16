package com.acme.example.junit.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompoundMatchersTest {

	private final int DEFAULT_VALUE = 99;
	
	private final int OTHER_VALUE = 0;
	
	private int testValue;
	
	@Before
	public void setUp() {
		testValue = DEFAULT_VALUE;
	}

	@After
	public void tearDown() {
	
	}
	
	
	@Test
	public void shouldBeAnyOfMatch() {
		List<Integer> list = Arrays.asList(1, DEFAULT_VALUE, 10);
		
		//List Matcher (import static org.hamcrest.collection.*)
		assertThat(list, hasSize(3));
		
		assertThat(list, contains(1, DEFAULT_VALUE, 10));
		assertThat(list, containsInAnyOrder(10, 1, DEFAULT_VALUE));
		assertThat(list, everyItem(greaterThan(0)));
	}
	

//	@Test
//	public void shouldBeAnyOfMatch() {
//		assertThat(testValue, either(is(100.00)).or(is(90.9)));
//	}
//	
//	@Test
//	public void shouldBeEitherMatch() {
//		assertThat(testValue, either(is(100.00)).or(is(90.9)));
//	}
//	
//	
//	@Test
//	public void verify_multiple_values() throws Exception {
//	double myMarks = 100.00;
//	assertThat(myMarks, either(is(100.00)).or(is(90.9)));
//	assertThat(myMarks, both(not(99.99)).and(not(60.00)));
//	assertThat(myMarks, );
//	assertThat(myMarks, not(anyOf(is(0.00),is(200.00))));
//	assertThat(myMarks, not(allOf(is(1.00),is(100.00),
//	is(30.00))));
//	}
	
	

}