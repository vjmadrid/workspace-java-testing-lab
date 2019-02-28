package com.acme.testing.mockito.basic.captor;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ArgumentCaptorTest {

	private List<String> mockedList;

	@Before
	public void setUp() {
		mockedList = mock(List.class);
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldVerifyStubbingSomeValueReturn() {
		ArgumentCaptor<Integer> localeCaptor = ArgumentCaptor.forClass(Integer.class);
		
		when(mockedList.get(localeCaptor.capture())).thenReturn("test");
		
		String value = mockedList.get(0);
		String secondValue = mockedList.get(1);
		
		int valueCaptor = localeCaptor.getValue();
			
		List<Integer> argumentCaptorList = localeCaptor.getAllValues();
		
		assertEquals(1, valueCaptor);
		assertEquals(2, argumentCaptorList.size());
		
	}
	
}