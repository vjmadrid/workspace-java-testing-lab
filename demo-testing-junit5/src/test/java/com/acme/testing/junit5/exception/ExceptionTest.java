package com.acme.testing.junit5.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

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
	public void shouldBeOneItemList() {
		System.out.println("[@Test] : shouldBeOneItemList");
		testList.add("element 1");
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(testList.size()));
	}
	
	@Test
	public void shouldBeEmptyList() {
		System.out.println("[@Test] : shouldBeEmptyList");
		
		assertTrue(testList.isEmpty());
	}
	
	// @Test(expected=RuntimeException.class) JUnit4
	@Test
	@Tag("failingTest")
	public void shouldBeRuntimeException() {
		System.out.println("[@Test Exception] : shouldBeRuntimeException");	
		
		assertThrows(RuntimeException.class, ()->{
			throw new RuntimeException();
		});
	}
	
	// @Test(expected=IndexOutOfBoundsException.class) JUnit4
	@Test
	@Tag("failingTest")
	public void shouldBeIndexOutOfBoundsException() {
		System.out.println("[@Test Exception] : shouldBeIndexOutOfBoundsException");
		
		assertThrows(IndexOutOfBoundsException.class, ()->{
			new ArrayList<Object>().get(0);
		});
		
	}
	
	@Test
	public void shouldBeIndexOutOfBoundsExceptionHandling() {
		System.out.println("[@Test Exception] : shouldBeIndexOutOfBoundsExceptionHandling");
		
		Exception exception = assertThrows(IndexOutOfBoundsException.class, ()->{
			new ArrayList<Object>().get(0);
		});
		
		assertEquals("Index: 0, Size: 0", exception.getMessage());
		
	}

}