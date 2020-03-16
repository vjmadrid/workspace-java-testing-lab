package com.acme.example.junit.hamcrest.matcher.custom;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.example.hamcrest.matcher.UserBaseMatcher;
import com.acme.testing.hamcrest.entity.User;
import com.acme.testing.hamcrest.factory.UserDataFactory;

public class BaseMatcherTest {

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
	public void shouldBeHasId() {
		//Con problema porque no se detalla el objeto Id como un long
		//assertThat(user, UserBaseMatcher.hasId(1L));
		
		//Hace la comprobación correcta
		assertThat(user, UserBaseMatcher.hasIdUser(1L));
	}

	
	
	
	
}