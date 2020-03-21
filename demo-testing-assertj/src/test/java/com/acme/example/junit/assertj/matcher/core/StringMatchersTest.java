package com.acme.example.junit.assertj.matcher.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.data.Index;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringMatchersTest {

	private String TEST_STRING = "Hola Mundo!";

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void shouldBeStringEqualsMatcher() {

		assertThat(TEST_STRING).isEqualTo("Hola Mundo!").isEqualToIgnoringCase("Hola MUNDO!");
	}

	@Test
	public void shouldBeStringMatcher() {

		assertThat(TEST_STRING).startsWith("H").endsWith("!").containsIgnoringCase("Mundo");
	}

	@Test
	public void shouldBeStringWithContainsMatcher() {
		
		 assertThat(TEST_STRING).containsOnlyOnce("Mundo");
	}
	
	@Test
	public void shouldBeStringWithContainsOnlyMatcher() {
		
		 assertThat("   ").containsOnlyWhitespaces();
		 assertThat(TEST_STRING).containsWhitespaces();
	}
	
	@Test
	public void shouldBeListStringMatcher() {
		
		List<String> list = Arrays.asList("Hola", "Mundo", "!");

        assertThat(list)
                .hasSize(3)
                .contains("Hola", "Mundo")
                .contains("Hola", Index.atIndex(0))
                .contains("Mundo", Index.atIndex(1))
                .contains("!", Index.atIndex(2))
                .doesNotContain("Loco");
	}

}