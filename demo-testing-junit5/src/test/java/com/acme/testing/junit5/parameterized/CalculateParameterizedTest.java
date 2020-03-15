package com.acme.testing.junit5.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.acme.testing.junit5.Calculate;



//@RunWith(Parameterized.class)
public class CalculateParameterizedTest {

// In JUnit 4	
//	private int expected;
//	private int param1;
//	private int param2;
//
//	public CalculateParameterizedTest(int expectedResult, int firstNumber, int secondNumber) {
//		this.expected = expectedResult;
//		this.param1 = firstNumber;
//		this.param2 = secondNumber;
//	}
//
//	@Parameters
//	public static Collection<Integer[]> useCase() {
//		return Arrays.asList(new Integer[][] { { 3, 1, 2 }, { 4, 2, 2 }, { 5, 3, 2 }, });
//	}
	
// In JUnit 4
//		@Test
//		public void sum() {
//			Calculate add = new Calculate();
//			assertEquals(expected, add.sum(param1, param2));
//		}
	
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = { " ", "   ", "\t", "\n" })
	void assertEmptyStrings(String text) {
	    assertTrue(text == null || text.trim().isEmpty());
	}
	
	@ParameterizedTest
	@EnumSource(ChronoUnit.class)
	void testChronoUnits(ChronoUnit chronoUnit) {
	    assertNotNull(chronoUnit);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "1", "uno", "primero"})
	void assertlengthString(String str) {
		assertTrue(str.length() > 0);
	}
	
	@ParameterizedTest(name = "{0} length is {1}")
	@CsvSource(value = { "1, 1", "uno, 3", "'',0", "primero, 7" })
	void length(String word, int expectedLength) {
		assertEquals(expectedLength, word.length());
	}
	
	static Collection<Integer[]> dataProvider() {
	    return Arrays.asList(new Integer[][] { { 3, 1, 2 }, { 4, 2, 2 }, { 5, 3, 2 }, });
	}

//
//	@ParameterizedTest
//	@MethodSource("dataProvider")
//	public void sum() {
//		Calculate add = new Calculate();
//		assertEquals(expected, add.sum(param1, param2));
//	}
	
}
