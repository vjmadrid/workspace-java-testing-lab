package com.acme.testing.junit.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

public class RulesTest {

	private ArrayList<String> testList;

	@Rule
	public TestName name = new TestName();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	
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
		System.out.println("[@Test] : "+name.getMethodName());
		assertEquals("shouldBeOneItemList", name.getMethodName());
	}
	
	@Test
	public void shouldBeEmptyList() {
		assertTrue(testList.isEmpty());
	
		System.out.println("[@Test] : "+name.getMethodName());
		assertEquals("shouldBeEmptyList", name.getMethodName());
	}
	
	public void shouldBeIndexOutOfBoundsException() throws IndexOutOfBoundsException {
		System.out.println("[@Test Exception] : shouldBeIndexOutOfBoundsException");	
	
		expectedException.expect(IndexOutOfBoundsException.class);
		expectedException.expectMessage("Index: 0, Size: 0");
		
		testList.get(0); // execution will never get past this line
	}

}