package com.acme.example.junit.hamcrest.matcher.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.object.HasToString.hasToString;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.testing.hamcrest.entity.User;
import com.acme.testing.hamcrest.factory.UserDataFactory;

public class ObjectMatchersTest {

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
	public void shouldBeUserEqualTo() {
		//JUnit
		assertEquals(user, cloneUser);
		
		//Hamcrest
		assertThat(user, equalTo(cloneUser));
	}
	
	@Test
	public void shouldBeInstanceOf() {
		assertThat(user, instanceOf(User.class));
		assertThat(user, is(not(instanceOf(Integer.class))));
	}
	
	@Test
	public void shouldBeNotNullValue() {
		assertThat(user, is(notNullValue()));
		assertThat(user, is(not(nullValue())));
	}
	
//	@Test
//	public void shouldBeUserStringValue(){
//	    String userString=user.toString();
//	    assertThat(user,HasToString(user));
//	}
	
	@Test
	public void givenBean_whenHasValue_thenCorrect() {
		//Cuidado se compara con el valor que tiene al convertir en string el atributo es "role" pero en string aparece como "rol"
	    assertThat(user, hasProperty("rol"));
	    //Requiere importar la clase adecuada en la seccion de imports
	    assertThat(user, hasProperty("rol", equalTo("USER")));
	    
	    assertThat(user, samePropertyValuesAs(cloneUser));
	}
	
	
}