package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
		testList = new ArrayList<String>();
		System.out.println("\t[@BeforeEach] : executeBeforeTestMethod");
	}

	// @After JUnit4
	@AfterEach
	public void executeAfterTestMethod() {
		testList.clear();
		System.out.println("\t[@AfterEach] : executeAfterTestMethod");
	}

	@Test
	public void shouldBeEmptyList() {
		assertTrue(testList.isEmpty());
		System.out.println("\t\t[@Test] : shouldBeEmptyList");

	}

	@Test
	void shouldBefailingTest() {
		System.out.println("\t\t[@Test] : shouldBefailingTest");
		fail("a failing test");
	}

	@Test
	public void shouldBeOneItemList() {
		testList.add("element 1");
		assertEquals(1, testList.size());
		System.out.println("\t\t[@Test]: shouldBeOneItemList");
	}

}