package com.acme.testing.mockito.basic.matcher;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArgumentMatchersTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		mockedList = mock(List.class);
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldVerifyArgumentMatcher() {
		when(mockedList.get(anyInt())).thenReturn("test");
	
		String value = mockedList.get(0);
		String otherValue = mockedList.get(99);
		
		verify(mockedList).get(0);
		verify(mockedList).get(99);
		assertEquals("test", value );
		assertEquals("test", otherValue );
	}
	
}