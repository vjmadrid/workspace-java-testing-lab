package com.acme.testing.junit5.core.disabledon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import com.acme.testing.junit5.test.util.annotation.so.DisabledOnNixSystems;

public class DisabledOnTest {

	private List<String> testList;
	
	@BeforeEach
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@AfterEach
	public void tearDown() {
		testList.clear();
	}

	@Test
	@DisabledOnOs(OS.WINDOWS)
	public void shouldBeEmptyListDisabledOnWindows() {
		System.out.println("[@Test] : shouldBeEmptyListDisabledOnWindows");
		
		assertTrue(testList.isEmpty());
	}
	
	@Test
	@DisabledOnOs(OS.MAC)
	public void shouldBeOneItemListDisabledOnMac() {
		System.out.println("[@Test] : shouldBeOneItemListDisabledOnMac");
		testList.add("element 1");
		
		assertEquals(1, testList.size());
	}
	
	@Test
	@DisabledOnNixSystems
	public void shouldBeOneItemListDisabledOnNixSystems() {
		System.out.println("[@Test] : shouldBeOneItemListDisabledOnNixSystems");
		testList.add("element 1");
		
		assertEquals(1, testList.size());
	}
	
	
	// conditionally enabling and disabling test
//	@Test
//	@DisabledIf("new Date().getDay() === 1")
//	public void shouldBeOneItemListDisabledIf() {
//		System.out.println("[@Test] : shouldBeOneItemListDisabledIf");
//		testList.add("element 1");
//		
//		assertEquals(1, testList.size());
//	}

}