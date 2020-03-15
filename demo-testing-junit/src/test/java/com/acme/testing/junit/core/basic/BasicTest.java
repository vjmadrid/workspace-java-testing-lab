package com.acme.testing.junit.core.basic;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class BasicTest {

	private List<String> testList;

	@Test
	public void shouldBeOneItemList() {
		System.out.println("[@Test] : shouldBeOneItemList");
		
		testList = new ArrayList<String>();
		
		testList.add("element 1");
		
		assertEquals(1, testList.size());
		
		testList.clear();		
	}
	
	@Test
	public void shouldBeEmptyList() {
		System.out.println("[@Test] : shouldBeEmptyList");
		
		testList = new ArrayList<String>();

		assertTrue(testList.isEmpty());
		
		testList.clear();
	}

}