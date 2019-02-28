package com.acme.testing.mockito.basic.verify;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NeverInvocationsVerifyTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		mockedList = mock(List.class);
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldCheckVerifyNeverInvocations() {
		List<String> secondMockedList = mock(List.class);
		
		mockedList.add("test");
	
		verify(mockedList).add("test");
		 
		verify(mockedList, never()).add("other test");
		 
		verifyZeroInteractions(secondMockedList);
	}
	
}