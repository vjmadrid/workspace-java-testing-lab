package com.acme.testing.junit.core.exception;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class ExceptionTest {

	private List<String> testList;
	
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
		System.out.println("[@Test] : shouldBeOneItemList");
		
		testList.add("element 1");
		
		assertEquals(1, testList.size());
	}
	
	@Test
	public void shouldBeEmptyList() {
		System.out.println("[@Test] : shouldBeEmptyList");
		
		assertTrue(testList.isEmpty());
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