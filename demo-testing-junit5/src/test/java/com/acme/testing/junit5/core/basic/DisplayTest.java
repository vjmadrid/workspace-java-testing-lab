package com.acme.testing.junit5.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("A example test case")
public class DisplayTest {

	private List<String> testList;
	
	@BeforeEach
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@AfterEach
	public void tearDown() {
		testList.clear();
	}

	@Tag("DEV")
	@Test
	@DisplayName("shouldBeOneItemList")
	public void shouldBeOneItemList() {
		System.out.println("[@Test] : shouldBeOneItemList");
		
		testList.add("element 1");
		
		assertEquals(1, testList.size());
	}
	
	@Tag("PROD")
	@Test
	@DisplayName("shouldBeEmptyList")
	public void shouldBeEmptyList() {
		System.out.println("[@Test] : shouldBeEmptyList");
		
		assertTrue(testList.isEmpty());
	}

}