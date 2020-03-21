package com.acme.example.junit.assertj.matcher.core;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.example.junit.assertj.entity.User;
import com.acme.example.junit.assertj.factory.UserDataFactory;

public class BasicObjectMatchersTest {

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
	public void shouldBeUserEqualsTo() {
		//JUnit
		assertEquals(user, cloneUser);
		
		//AssertJ
		assertThat(user).isEqualTo(cloneUser);
	}
	
	@Test
	public void shouldBeUserEqualsToRecursively() {
		//JUnit
		assertEquals(user, cloneUser);
		
		//AssertJ
		assertThat(user).isEqualToComparingFieldByFieldRecursively(cloneUser);
	}
	

	
	
}