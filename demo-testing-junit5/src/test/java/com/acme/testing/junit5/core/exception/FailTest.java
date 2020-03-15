package com.acme.testing.junit5.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FailTest {

	private List<String> testList;
	
	@BeforeEach
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@AfterEach
	public void tearDown() {
		testList.clear();
	}

	@Test
	public void shouldBeOneItemListWithFail() {
		System.out.println("[@Test] : shouldBeOneItemListWithFail");
		testList.add("element 1");
		
		//Active fail
		//fail("Error Custom");
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(testList.size()));
	}
	
}