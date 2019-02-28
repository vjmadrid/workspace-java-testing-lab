package com.acme.testing.junit.exception;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

public class RulesTest {

	private ArrayList<String> testList;

	@Rule
	public TestName name = new TestName();

	@Rule
	public ExpectedException expectedException;

	
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

}