package com.acme.testing.mockito.basic.finalclazz;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.acme.testing.mockito.example.test.entity.clazz.ExampleFinalClass;

public class FinalClazzTest {

	ExampleFinalClass exampleFinalClass;

	@Before
	public void setUp() {
		exampleFinalClass = new ExampleFinalClass();
	}

	@After
	public void tearDown() {
	}

	@Test
	@Ignore("Use with Mockito v2 create file org.mockito.plugins.MockMaker ")
	public void shouldCheckVerifyMethod() {
		ExampleFinalClass mockExampleFinalClass = mock(ExampleFinalClass.class);
		
		when(mockExampleFinalClass.exampleFinalMethod()).thenReturn("test");

		assertEquals(mockExampleFinalClass.exampleFinalMethod(), exampleFinalClass.exampleFinalMethod());
	}

}