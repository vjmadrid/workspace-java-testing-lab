package com.acme.example.junit.hamcrest.matcher.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.testing.hamcrest.entity.User;
import com.acme.testing.hamcrest.factory.UserDataFactory;

public class BasicMatchersTest {

	private User user;
	
	private User anotherUser;

	private User cloneUser;
	
	@Before
	public void setUp() {
		user = UserDataFactory.createSampleUserDefault();
		cloneUser =  UserDataFactory.createSampleUserDefault();
		anotherUser = UserDataFactory.createSampleUserDefault();
		anotherUser.setId(2L);
	}

	@After
	public void tearDown() {
	
	}
	
	@Test
	public void shouldBeUserEqualsIs() {
		//JUnit
		assertEquals(user, cloneUser);
		
		//Hamcrest
		assertThat(user, is(cloneUser));
	}
	
	@Test
	public void shouldBeUserEqualsAnything() {
		assertThat(user, anything());
	}
	
	
}