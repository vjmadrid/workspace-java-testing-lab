package com.acme.testing.mockito.basic.annotation;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class MockitoRuleWithVerifyTest {

	@Mock
	private List<String> mockedList;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule(); // Create mocks based on the @Mock annotation

	@Before
	public void setUp() {
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