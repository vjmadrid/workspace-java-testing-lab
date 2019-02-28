package com.acme.example.junit.hamcrest.matcher.core;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.testing.hamcrest.entity.User;
import com.acme.testing.hamcrest.factory.UserDataFactory;

public class LogicalMatchersTest {

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
	public void shouldBeUserEqualsNot() {
		assertThat(user, not(anotherUser));
	}
	
	@Test
	public void shouldBeUserEqualsAllOf() {
		assertThat(user, allOf(is(cloneUser),not(anotherUser)));
	}
	
	@Test
	public void shouldBeUserEqualsAnyOf() {
		assertThat(user, anyOf(is(nullValue()),is(cloneUser),not(anotherUser)));
	}
	
}