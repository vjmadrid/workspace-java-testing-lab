package com.acme.testing.mockito.basic.verify;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class OrderVerifyTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		mockedList = mock(List.class);
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldCheckOrderVerify() {
		List<String> secondMockedList = mock(List.class);
		
		mockedList.add("two");
		mockedList.add("first");
		
		secondMockedList.add("second");
		 
		InOrder inOrder = inOrder(mockedList, secondMockedList);
		
		inOrder.verify(mockedList).add("two");
		inOrder.verify(mockedList).add("first");
		
		inOrder.verify(secondMockedList).add("second");
	}
	
	
}