package com.acme.testing.mockito.basic.annotation;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;


public class AnnotationBehaviorVerifyTest {

	@Mock
	private List<String> mockedList;

	@Before
	public void setUp() {
		initMocks(this);
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