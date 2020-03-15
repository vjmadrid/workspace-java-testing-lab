package com.acme.testing.junit.core.basic;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class SetupTeardownTest {

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
	public void shouldBeOneItemList() {
		System.out.println("[@Test] : shouldBeOneItemList");
		
		testList.add("element 1");
		
		assertEquals(1, testList.size());
	}
	
	@Test
	public void shouldBeEmptyList() {
		System.out.println("[@Test] : shouldBeEmptyList");
		
		assertTrue(testList.isEmpty());
	}

}