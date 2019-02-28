package com.acme.example.junit.hamcrest.matcher.custom;

import static com.acme.example.hamcrest.matcher.HasEqualsNameMatcher.hasEqualsName;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.testing.hamcrest.entity.User;
import com.acme.testing.hamcrest.factory.UserDataFactory;

public class HasEqualsNameMatcherTest {

	private User user;
	
	private User anotherUser;

	private User cloneUser;
	
	@Before
	public void setUp() {
		user = UserDataFactory.createSampleUserDefault();
		cloneUser =  UserDataFactory.createSampleUserDefault();
		anotherUser = UserDataFactory.createSampleUserDefault();
		anotherUser.setId(2L);
		anotherUser.setName("OTHER");
	}

	@After
	public void tearDown() {
	
	}
	
	@Test
	public void shouldBeHasEqualsId() {
		assertThat(user, hasEqualsName(cloneUser));
	}
	
	@Test
	public void shouldBeNoHasEqualsId() {
		assertThat(user, not(hasEqualsName(anotherUser)));
	}

	
	
	
	
}