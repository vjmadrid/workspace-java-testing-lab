package com.acme.testing.junit.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FailTest {

	private List<String> testList;
	
	@Before
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		testList.clear();
	}

	@Test
	public void shouldBeOneItemListWithFail() {
		System.out.println("[@Test] : shouldBeOneItemListWithFail");
		testList.add("element 1");
		
		//Active fail
		//fail("Error Custom");
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(testList.size()));
	}
	
}