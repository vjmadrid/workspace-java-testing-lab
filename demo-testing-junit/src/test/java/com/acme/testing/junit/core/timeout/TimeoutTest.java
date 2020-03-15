package com.acme.testing.junit.core.timeout;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TimeoutTest {

	private List<String> testList;
	
	@Before
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		testList.clear();
	}

	@Test
	public void shouldBeOneItemList() {
		System.out.println("[@Test] : shouldBeOneItemList");
		
		testList.add("element 1");
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(testList.size()));
	}
	
	@Test(timeout = 3000)
	public void shouldBeOneItemListIn3Seconds() {
		System.out.println("[@Test] : shouldBeOneItemListIn3Seconds");
	
		testList.add("element 1");
	
		assertEquals(1, testList.size());
	}

	@Test(timeout = 3000)
	@Ignore
	public void shouldBePerformanceErrorTest() {
		System.out.println("[@Test] : shouldBePerformanceErrorTest");
	
		for (int i = 0; i <= 1000000; i++) {
			int j = i;
			System.out.println(j);
		}
		
		assertTrue(true);
	}

	private void assertTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}