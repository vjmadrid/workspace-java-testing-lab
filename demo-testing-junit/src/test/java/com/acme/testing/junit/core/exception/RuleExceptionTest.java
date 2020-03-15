package com.acme.testing.junit.core.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

public class RuleExceptionTest {

	private List<String> testList;

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
		System.out.println("[@Test] : "+name.getMethodName());
		
		testList.add("element 1");
		
		assertEquals(1, testList.size());
		assertEquals("shouldBeOneItemList", name.getMethodName());
	}
	
	@Test
	public void shouldBeEmptyList() {
		System.out.println("[@Test] : "+name.getMethodName());
		
		assertTrue(testList.isEmpty());
	
		assertEquals("shouldBeEmptyList", name.getMethodName());
	}
	
	@Test
	public void shouldBeIndexOutOfBoundsException() {
		System.out.println("[@Test Exception] : shouldBeIndexOutOfBoundsException");	
	
		expectedException.expect(IndexOutOfBoundsException.class);
		expectedException.expectMessage("Index: 0, Size: 0");
		
		testList.get(0); 
	}
	
	@Test
	public void shouldBeIndexOutOfBoundsExceptionWithSuperClass() {
		System.out.println("[@Test Exception] : shouldBeIndexOutOfBoundsExceptionWithSuperClass");	
	
		expectedException.expect(Exception.class);
		expectedException.expectMessage("Index: 0, Size: 0");
		
		testList.get(0); 
	}

}