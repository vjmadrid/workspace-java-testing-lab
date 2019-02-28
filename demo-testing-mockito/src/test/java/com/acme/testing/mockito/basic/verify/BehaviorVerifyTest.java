package com.acme.testing.mockito.basic.verify;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BehaviorVerifyTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		mockedList = mock(List.class);
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldCheckVerifyMethod() {
		mockedList.add("test");
		mockedList.clear();

		verify(mockedList).add("test");
		verify(mockedList).clear();
	}
	
	
}