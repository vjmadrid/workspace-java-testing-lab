package com.acme.example.hamcrest.matcher;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.acme.testing.hamcrest.entity.User;

public class HasEqualsIdMatcher extends TypeSafeMatcher<User> {

	private final User expectedUser;
	
	public HasEqualsIdMatcher(final User user) {
	    this.expectedUser = user;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("expected result from getId(): ").appendValue(expectedUser.getId());	
	}
	
	@Override
	protected boolean matchesSafely(final User user) {
		return expectedUser.getId() == user.getId();
	}
	
	public static HasEqualsIdMatcher hasEqualsId(final User user) {
        return new HasEqualsIdMatcher(user);
    }
	
}
