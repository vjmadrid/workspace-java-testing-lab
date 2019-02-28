package com.acme.testing.junit.core;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class FixtureMethodsTest {

	private ArrayList<String> testList;
	
	@BeforeClass
	public static void onceExecuteBeforeAll() {
		System.out.println("[@BeforeClass] : onceExecuteBeforeAll");
	}

	@AfterClass
	public static void onceExecuteAfterAll() {
		System.out.println("[@AfterClass] onceExecuteAfterAll");
	}
	
	@Before
	public void executeBeforeTestMethod() {
		testList = new ArrayList<String>();
		System.out.println("\t[@Before] : executeBeforeTestMethod");
	}

	@After
	public void executeAfterTestMethod() {
		testList.clear();
		System.out.println("\t[@After] : executeAfterTestMethod");
	}

	@Test
	public void shouldBeEmptyList() {
		assertTrue(testList.isEmpty());
		System.out.println("\t\t[@Test] : shouldBeEmptyList");

	}

	@Test
	public void shouldBeOneItemList() {
		testList.add("element 1");
		assertEquals(1, testList.size());
		System.out.println("\t\t[@Test]: shouldBeOneItemList");
	}

}