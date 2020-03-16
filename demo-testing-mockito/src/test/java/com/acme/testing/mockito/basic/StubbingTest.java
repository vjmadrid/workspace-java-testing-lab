package com.acme.testing.mockito.basic;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StubbingTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		//Creacion Mock
		mockedList = mock(List.class);
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldVerifyStubbingOneValueReturn() {
		//Stubbing
		when(mockedList.get(0)).thenReturn("test");
	
		String value = mockedList.get(0);
		
		verify(mockedList).get(0);
		assertEquals("test", value );
	}
	
	@Test
	public void shouldVerifyStubbingNullDefaultValueReturn() {
		//Stubbing
		when(mockedList.get(0)).thenReturn("test");
	
		String value = mockedList.get(99);
		
		verify(mockedList).get(99);
		assertNull(value);
	}
	
	@Test
	public void shouldVerifyStubbingSomeValueReturn() {
		//Stubbing
		//when(mockedList.get(0)).thenReturn("test 1", "test 2", "test 3");
		when(mockedList.get(0)).thenReturn("test 1").thenReturn("test 2").thenReturn("test 3");
	
		String firstValue = mockedList.get(0);
		String secondValue = mockedList.get(0);
		String thirdValue = mockedList.get(0);
		String fourthValue = mockedList.get(0);
		
		verify(mockedList,times(4)).get(0);
		assertEquals("test 1", firstValue);
		assertEquals("test 2", secondValue);
		assertEquals("test 3", thirdValue);
		assertEquals("test 3", fourthValue);
	}
		
	@Test (expected=RuntimeException.class)
	public void shouldVerifyStubbingExceptionReturn() {
		//Stubbing		
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		mockedList.get(1);
	}
	

	
	@Test (expected=RuntimeException.class)
	public void shouldVerifyStubbingDoThrowExceptionReturn() {
		//Stubbing		
		doThrow(new RuntimeException()).when(mockedList).get(1); 

		mockedList.get(1);
	}
	
	@Test
	public void shouldVerifyStubbingOneValueReturnWithdoReturnWhen() {
		//Stubbing similar to when().ThenReturn()
		// * used in mocking methods which give an exception during a call 
		// * used with spy
		doReturn("test").when(mockedList).get(0);
	
		String value = mockedList.get(0);
		
		verify(mockedList).get(0);
		assertEquals("test", value );
	}


	
}