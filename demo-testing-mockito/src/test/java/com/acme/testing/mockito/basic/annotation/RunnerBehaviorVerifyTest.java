package com.acme.testing.mockito.basic.annotation;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RunnerBehaviorVerifyTest {

	@Mock
	private List<String> mockedList;

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