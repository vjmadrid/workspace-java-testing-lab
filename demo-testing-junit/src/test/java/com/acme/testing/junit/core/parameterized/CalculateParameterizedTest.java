package com.acme.testing.junit.core.parameterized;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.acme.testing.junit.Calculate;

@RunWith(Parameterized.class)
public class CalculateParameterizedTest {

	private int expected;
	private int param1;
	private int param2;

	public CalculateParameterizedTest(int expectedResult, int firstNumber, int secondNumber) {
		this.expected = expectedResult;
		this.param1 = firstNumber;
		this.param2 = secondNumber;
	}

	@Parameters
	public static Collection<Integer[]> useCase() {
		return Arrays.asList(new Integer[][] { { 3, 1, 2 }, { 4, 2, 2 }, { 5, 3, 2 }, });
	}

	@Test
	public void sum() {
		Calculate add = new Calculate();
		assertEquals(expected, add.sum(param1, param2));
	}
}
