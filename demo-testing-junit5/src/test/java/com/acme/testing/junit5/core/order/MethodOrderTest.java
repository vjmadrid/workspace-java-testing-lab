package com.acme.testing.junit5.core.order;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//	In JUnit 4
//		@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
//		@FixMethodOrder(MethodSorters.JVM)
//		@FixMethodOrder(MethodSorters.DEFAULT)

// In JUnit 5 : Random.class , OrderAnnotation.class and Alphanumeric.class
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTest {

	@Test
	@Order(4)
	public void shouldBeA() {
		System.out.println("[@Test] : shouldBeA");
	}

	@Test
	@Order(2)
	public void shouldBeB() {
		System.out.println("[@Test] : shouldBeB");
	}

	@Test
	@Order(3)
	public void shouldBeC() {
		System.out.println("[@Test] : shouldBeC");
	}

	@Test
	@Order(1)
	public void shouldBeD() {
		System.out.println("[@Test] : shouldBeD");
	}
}
