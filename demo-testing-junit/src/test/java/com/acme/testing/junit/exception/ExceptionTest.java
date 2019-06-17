package com.acme.testing.junit.exception;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class ExceptionTest {

	private ArrayList<String> testList;
	
	@Before
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		testList.clear();
	}

	@Test
	public void shouldBeOneItemList() {
		testList.add("element 1");
		assertEquals(1, testList.size());
		System.out.println("[@Test] : shouldBeOneItemList");
	}
	
	@Test
	public void shouldBeEmptyList() {
		assertTrue(testList.isEmpty());
		System.out.println("[@Test] : shouldBeEmptyList");
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldBeRuntimeException() {
		System.out.println("[@Test Exception] : shouldBeRuntimeException");	
		throw new RuntimeException();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldBeIndexOutOfBoundsException() {
		System.out.println("[@Test Exception] : shouldBeIndexOutOfBoundsException");	
		new ArrayList<Object>().get(0); 
	}

}