package com.acme.testing.junit5.core.basic;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class AssertionsTest {

	private String DEFAULT_VALUE = "test";
	
	@Test
	public void assertsBooleanConditions(){
		int example = 1;
		int anotherExample = 2;
	
		Assertions.assertTrue(example < anotherExample);
		Assertions.assertFalse(example > anotherExample);
	}
	
	@Test
	public void assertNullAndNotNullObjectValues(){
		Object object = null;
		Assertions.assertNull(object);
		
		object = new String(DEFAULT_VALUE);
		Assertions.assertNotNull(object);
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
	public void assertNotSameConditions() {
		Integer example = new Integer("10");
		Integer anotherExample = new Integer("10");
		
		assertNotSame(example, anotherExample);
	}
	
	@Test
	public void assertSame2Conditions() {
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
