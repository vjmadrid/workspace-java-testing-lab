package com.acme.testing.junit.core;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class IgnoreTest {

	private ArrayList<String> testList;
	
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
		testList.add("element 1");
		assertEquals(1, testList.size());
		System.out.println("[@Test] : shouldBeOneItemList");
	}
	
	@Test
	public void shouldBeEmptyList() {
		assertTrue(testList.isEmpty());
		System.out.println("[@Test] : shouldBeEmptyList");
	}
	
	@Ignore
	@Test
	public void shouldBeIgnored() {
		System.out.println("[@Ignore] : shouldBeIgnored");
	}
	
	@Ignore("Ignore Message")
	@Test
	public void shouldBeIgnoredWithMessage() {
		System.out.println("[@Ignore] : shouldBeIgnoredWithMessage");
	}

}