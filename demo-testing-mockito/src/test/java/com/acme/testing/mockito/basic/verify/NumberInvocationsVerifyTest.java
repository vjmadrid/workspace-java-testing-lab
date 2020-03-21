package com.acme.testing.mockito.basic.verify;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumberInvocationsVerifyTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		mockedList = mock(List.class);
		loadData();	
	}

	private void loadData(){
		mockedList.add("once time");

		mockedList.add("twice times");
		mockedList.add("twice times");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldCheckNumberInvocationsVerify() {
		verify(mockedList).add("once time");
		
		verify(mockedList, times(1)).add("once time");

		verify(mockedList, times(2)).add("twice times");
		verify(mockedList, times(3)).add("three times");
	}
	
	@Test
	public void shouldCheckNeverInvocationVerify() {
		verify(mockedList, never()).add("never");		
	}

	@Test
	public void shouldCheckOtherInvocationVerify() {
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");		
	}


	
	
}