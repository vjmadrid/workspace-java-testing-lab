package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FixtureMethodsTest {

	private List<String> testList;

	// @BeforeClass JUnit4
	@BeforeAll
	public static void onceExecuteBeforeAll() {
		System.out.println("[@BeforeClass] : onceExecuteBeforeAll");
	}

	// @AfterClass JUnit4
	@AfterAll
	public static void onceExecuteAfterAll() {
		System.out.println("[@AfterAll] onceExecuteAfterAll");
	}

	// @Before JUnit4
	@BeforeEach
	public void executeBeforeTestMethod() {
		System.out.println("\t[@BeforeEach] : executeBeforeTestMethod");
		testList = new ArrayList<String>();
	}

	// @After JUnit4
	@AfterEach
	public void executeAfterTestMethod() {
		System.out.println("\t[@AfterEach] : executeAfterTestMethod");
		
		testList.clear();
	}

	@Test
	public void shouldBeEmptyList() {
		System.out.println("\t\t[@Test] : shouldBeEmptyList");
		
		assertTrue(testList.isEmpty());
	}

//	@Test
//	void shouldBefailingTest() {
//		System.out.println("\t\t[@Test] : shouldBefailingTest");
//		fail("a failing test");
//	}

	@Test
	public void shouldBeOneItemList() {
		System.out.println("\t\t[@Test]: shouldBeOneItemList");
		
		testList.add("element 1");
		assertEquals(1, testList.size());
	}

}