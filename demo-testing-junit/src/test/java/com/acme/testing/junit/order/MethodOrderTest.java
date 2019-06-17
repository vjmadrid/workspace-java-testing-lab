package com.acme.testing.junit.order;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.JVM)
@FixMethodOrder(MethodSorters.DEFAULT)
public class MethodOrderTest {

	@Test
	public void shouldBeA() {
		System.out.println("[@Test] : shouldBeA");
	}

	@Test
	public void shouldBeB() {
		System.out.println("[@Test] : shouldBeB");
	}

	@Test
	public void shouldBeC() {
		System.out.println("[@Test] : shouldBeC");
	}

	@Test
	public void shouldBeD() {
		System.out.println("[@Test] : shouldBeD");
	}
}
