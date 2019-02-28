package com.acme.example.hamcrest.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import com.acme.testing.hamcrest.entity.User;

public class HasEqualsNameMatcher extends BaseMatcher<User> {

	private final User expectedUser;
	
	public HasEqualsNameMatcher(final User user) {
	    this.expectedUser = user;
	}
	
	@Override
	public boolean matches(Object item) {
		final User user = (User) item;
        return expectedUser.getName().equals(user.getName());
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("getName() should return ").appendValue(expectedUser.getName());
	}
	
	public static HasEqualsNameMatcher hasEqualsName(final User user) {
        return new HasEqualsNameMatcher(user);
    }

}
