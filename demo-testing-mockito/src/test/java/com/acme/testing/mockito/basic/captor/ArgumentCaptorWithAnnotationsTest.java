package com.acme.testing.mockito.basic.captor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class ArgumentCaptorWithAnnotationsTest {

	@Mock
	private List<String> mockedList;
	
	@Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<Integer> captor;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void shouldVerifyStubbingSomeValueReturn() {

		when(mockedList.get(captor.capture())).thenReturn("test");
		
		String value = mockedList.get(0);
		String secondValue = mockedList.get(1);
		
		int valueCaptor = captor.getValue();
			
		List<Integer> argumentCaptorList = captor.getAllValues();
		
		assertEquals(1, valueCaptor);
		assertEquals(2, argumentCaptorList.size());
	}
	
}