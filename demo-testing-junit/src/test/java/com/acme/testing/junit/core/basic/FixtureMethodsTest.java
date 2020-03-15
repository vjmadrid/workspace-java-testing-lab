package com.acme.testing.junit.core.basic;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class FixtureMethodsTest {

	private List<String> testList;
	
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
		System.out.println("\t[@After] : executeAfterTestMethod");
		
		testList.clear();
	}

	@Test
	public void shouldBeEmptyList() {
		System.out.println("\t\t[@Test] : shouldBeEmptyList");
		
		assertTrue(testList.isEmpty());
	}

	@Test
	public void shouldBeOneItemList() {
		System.out.println("\t\t[@Test]: shouldBeOneItemList");
		
		testList.add("element 1");
		
		assertEquals(1, testList.size());
	}

}