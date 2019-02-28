package com.acme.testing.junit.core;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AssertionsTest {

	private String DEFAULT_VALUE = "test";
	
	@Test
	public void assertsBooleanConditions(){
		int example = 1;
		int anotherExample = 2;
	
		Assert.assertTrue(example < anotherExample);
		Assert.assertFalse(example > anotherExample);
	}
	
	@Test
	public void assert_null_and_not_null_object_values(){
		Object object = null;
		Assert.assertNull(object);
		
		object = new String(DEFAULT_VALUE);
		Assert.assertNotNull(object);
	}
	
	@Test
	public void assertEqualsConditions(){
		Integer example = 10;
		Integer anotherExample = 10;
		
		assertEquals(example, anotherExample);
	}
	
	@Test
	public void assertSameConditions(){
		Integer example = 10;
		Integer anotherExample = 10;
		
		assertSame(example, anotherExample);
	}
	
	@Test
	public void assertNotSameConditions() throws Exception {
		Integer example = new Integer("10");
		Integer anotherExample = new Integer("10");
		
		assertNotSame(example, anotherExample);
	}
	
	@Test
	public void assertSame2Conditions() throws Exception {
		Integer example = new Integer("10");
		Integer anotherExample = example;
		
		assertSame(example, anotherExample);
	}
	
	@Test
	public void assertEqualsArrayConditions(){
		int[] example = {1, 2, 3, 4, 5};
		int[] anotherExample = {1, 2, 3, 4, 5};
	
		assertArrayEquals(example, anotherExample);
	}

}
