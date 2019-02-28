package com.acme.example.junit.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.everyItem;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoreMatchersTest {

	private final Integer DEFAULT_VALUE = 99;
	
	private final Integer OTHER_VALUE = 0;
	
	private Integer testValue;
	
	@Before
	public void setUp() {
		testValue = DEFAULT_VALUE;
	}

	@After
	public void tearDown() {
	
	}
	
	@Test
	public void shouldBeObjectCoreMatcher() {
		//JUnit
		assertNotNull(testValue);
		
		//Hamcrest
		assertThat(testValue, is(notNullValue()));
	}
	
	@Test
	public void shouldBeListMatcher() {
		List<Integer> list = Arrays.asList(1, DEFAULT_VALUE, 10);
		
		//List Matcher (import static org.hamcrest.collection.*)
		assertThat(list, hasSize(3));
		
		//Comprueba si un elemento/s estan en una coleccion
		assertThat(list, hasItem(DEFAULT_VALUE));
		assertThat(list, not(hasItem(25)));
		assertThat(list, hasItems(10,DEFAULT_VALUE));
		
		//Comprueba si todos los elementos estan en la colección (contains con orden estricto)
		assertThat(list, contains(1, DEFAULT_VALUE, 10));
		assertThat(list, containsInAnyOrder(10, 1, DEFAULT_VALUE));
		
		//Comprueba una coleccion para cada elemento de la lista
		assertThat(list, everyItem(greaterThan(0)));
	}
	
}