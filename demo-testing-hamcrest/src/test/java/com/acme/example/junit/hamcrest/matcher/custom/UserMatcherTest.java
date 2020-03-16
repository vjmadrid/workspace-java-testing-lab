package com.acme.example.junit.hamcrest.matcher.custom;

import static com.acme.example.hamcrest.matcher.HasEqualsIdMatcher.hasEqualsId;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.testing.hamcrest.entity.User;
import com.acme.testing.hamcrest.factory.UserDataFactory;

public class UserMatcherTest {

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
	public void shouldBeHasEqualsId() {
		assertThat(user, hasEqualsId(cloneUser));
	}
	
	@Test
	public void shouldBeNoHasEqualsId() {
		assertThat(user, not(hasEqualsId(anotherUser)));
	}

	
	
	
	
}