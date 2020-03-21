package com.acme.example.junit.assertj.matcher.core;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExceptionMatchersTest {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	private int divide(int input1, int input2) {
		return input1 / input2;
	}

	@Test
	public void shouldBeExceptionMatcher() {

		assertThatThrownBy(() -> {
			divide(1, 0);
		}).isInstanceOf(ArithmeticException.class).hasMessageContaining("zero").hasMessage("/ by zero");
	}
	
	@Test
	public void shouldBeException2Matcher() {
		List<String> list = Arrays.asList("Hola", "Mundo", "!");

		assertThatThrownBy(() -> {
			list.get(10);
		}).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("10").hasMessage("10");
	}

}