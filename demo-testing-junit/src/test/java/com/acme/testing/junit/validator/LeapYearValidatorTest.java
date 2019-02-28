package com.acme.testing.junit.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.testing.junit.validator.LeapYearValidator;

public class LeapYearValidatorTest {


	private final int TEST_NO_LEAP_YEAR = 2017;
	private final int TEST_LEAP_YEAR = 1988;
	private final int TEST_NO_LEAP_YEAR_EARLY_CENTURY = 1800;
	private final int TEST_LEAP_YEAR_EARLY_CENTURY = 2400;
	

	@Before
	public void init() {
	
	}

	/*
	 * Gregorian Calendar
	 */
	
	@Test
	public void shouldNoBeLeapYearGregorianCalendar() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearGregorianCalendar(TEST_NO_LEAP_YEAR));
	}
	
	@Test
	public void shouldBeLeapYearGregorianCalendar() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearGregorianCalendar(TEST_LEAP_YEAR));
	}
	
	@Test
	public void shouldNoBeLeapYearGregorianCalendarEarlyCentury() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearGregorianCalendar(TEST_NO_LEAP_YEAR_EARLY_CENTURY));
	}
	
	@Test
	public void shouldBeLeapYearGregorianCalendarEarlyCentury() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearGregorianCalendar(TEST_LEAP_YEAR_EARLY_CENTURY));
	}
	
	/*
	 * Condition 1
	 */
	
	@Test
	public void shouldNoBeLeapYearCondition1() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition1(TEST_NO_LEAP_YEAR));
	}
	
	@Test
	public void shouldBeLeapYearCondition1() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition1(TEST_LEAP_YEAR));
	}
	
	@Test
	public void shouldNoBeLeapYearCondition1EarlyCentury() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition1(TEST_NO_LEAP_YEAR_EARLY_CENTURY));
	}
	
	@Test
	public void shouldBeLeapYearCondition1EarlyCentury() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition1(TEST_LEAP_YEAR_EARLY_CENTURY));
	}
	
	/*
	 * Condition 2
	 */
	
	@Test
	public void shouldNoBeLeapYearCondition2() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition2(TEST_NO_LEAP_YEAR));
	}
	
	@Test
	public void shouldBeLeapYearCondition2() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition2(TEST_LEAP_YEAR));
	}
	
	@Test
	public void shouldNoBeLeapYearCondition2EarlyCentury() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition2(TEST_NO_LEAP_YEAR_EARLY_CENTURY));
	}
	
	@Test
	public void shouldBeLeapYearCondition2EarlyCentury() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition2(TEST_LEAP_YEAR_EARLY_CENTURY));
	}
	
	/*
	 * Condition 3
	 */
	
	@Test
	public void shouldNoBeLeapYearCondition3() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition3(TEST_NO_LEAP_YEAR));
	}
	
	@Test
	public void shouldBeLeapYearCondition3() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition3(TEST_LEAP_YEAR));
	}
	
	@Test
	public void shouldNoBeLeapYearCondition3EarlyCentury() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition3(TEST_NO_LEAP_YEAR_EARLY_CENTURY));
	}
	
	@Test
	public void shouldBeLeapYearCondition3EarlyCentury() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition3(TEST_LEAP_YEAR_EARLY_CENTURY));
	}
	
	/*
	 * Condition 4
	 */
	
	@Test
	public void shouldNoBeLeapYearCondition4() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition4(TEST_NO_LEAP_YEAR));
	}
	
	@Test
	public void shouldBeLeapYearCondition4() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition4(TEST_LEAP_YEAR));
	}
	
	@Test
	public void shouldNoBeLeapYearCondition4EarlyCentury() {
		assertFalse(LeapYearValidator.INSTANCE.isLeapYearCondition4(TEST_NO_LEAP_YEAR_EARLY_CENTURY));
	}
	
	@Test
	public void shouldBeLeapYearCondition4EarlyCentury() {
		assertTrue(LeapYearValidator.INSTANCE.isLeapYearCondition4(TEST_LEAP_YEAR_EARLY_CENTURY));
	}
	
	

	
}