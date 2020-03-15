package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Disabled
public class DisableTest {

	private List<String> testList;
	
	@BeforeEach
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@AfterEach
	public void tearDown() {
		testList.clear();
	}

	//@Ignore("Ignore Message") In JUnit 4
	@Tag("DEV")
	@Test
	//@Disabled
	@Disabled("purpose message")
	public void shouldBeOneItemList() {
		testList.add("element 1");
		assertEquals(1, testList.size());
		System.out.println("[@Test] : shouldBeOneItemList");
	}
	
	@Tag("PROD")
	@Test
	public void shouldBeEmptyList() {
		assertTrue(testList.isEmpty());
		System.out.println("[@Test] : shouldBeEmptyList");
	}

}