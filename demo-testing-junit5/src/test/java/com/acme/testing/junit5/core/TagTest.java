package com.acme.testing.junit5.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Test case")
public class TagTest {
	
	private List<String> testList;

	@Test
	@Tag("Method")
	public void shouldBeOneItemList() {
		testList = new ArrayList<String>();

		testList.add("element 1");
		assertEquals(1, testList.size());
		
		testList.clear();
		System.out.println("[@Test] : shouldBeOneItemList");
	}

}