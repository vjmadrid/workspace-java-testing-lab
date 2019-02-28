package com.acme.testing.junit.core;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class BasicTest {

	private ArrayList<String> testList;

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