package com.acme.testing.mockito.basic.verify;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.exceptions.verification.NoInteractionsWanted;

public class RedundantInvocationsVerifyTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		mockedList = mock(List.class);
	}

	@After
	public void tearDown() {
	}
	
	@Test (expected=NoInteractionsWanted.class)
	public void shouldCheckVerifyNeverInvocations() {
		mockedList.add("test");
		mockedList.add("other test");
		 
		verify(mockedList).add("test");
		
		verifyNoMoreInteractions(mockedList);
	}
	
}