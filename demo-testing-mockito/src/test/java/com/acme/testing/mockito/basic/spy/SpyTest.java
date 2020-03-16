package com.acme.testing.mockito.basic.spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SpyTest {

	private final String TEST_VALUE = "test";

	List<String> list = null;
	List<String> spyTest;

	@Before
	public void setUp() {
		list = new LinkedList<>();
		spyTest = spy(list);
	}

	@After
	public void tearDown() {
	}

	@Test
	@Ignore("Falla al ser spy y usar when")
	public void shouldCheckVerifySpyWrong() {
		when(spyTest.get(0)).thenReturn(TEST_VALUE);

		assertEquals(TEST_VALUE, spyTest.get(0));
	}
	
	@Test
	public void shouldCheckVerifySpyCorrect() {
		doReturn(TEST_VALUE).when(spyTest).get(0);

		assertEquals(TEST_VALUE, spyTest.get(0));
	}

}