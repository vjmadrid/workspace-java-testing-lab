package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BasicTest {

	private List<String> testList;

	@Test
	public void shouldBeOneItemList() {
		testList = new ArrayList<String>();

		testList.add("element 1");
		assertEquals(1, testList.size());
		
		testList.clear();
		System.out.println("[@Test] : shouldBeOneItemList");
	}
	
	@Test
	public void shouldBeEmptyList() {
		testList = new ArrayList<String>();

		assertTrue(testList.isEmpty());
		
		testList.clear();
		System.out.println("[@Test] : shouldBeEmptyList");
	}

}