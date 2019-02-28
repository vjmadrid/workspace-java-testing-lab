package com.acme.example.hamcrest.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.acme.testing.hamcrest.entity.User;

public class UserBaseMatcher {

	public static Matcher<Object> hasId(final Long id) {
		return new BaseMatcher<Object>() {
			
			protected Long expectedId = id;

			@Override
			public boolean matches(Object object) {
				return expectedId.equals(object);
			}

			@Override
			public void describeTo(Description description) {
				description.appendText(expectedId.toString());
			}
			
		};
	}
	
	public static Matcher<User> hasIdUser(final Long id) {
		return new BaseMatcher<User>() {
			
			protected Long expectedId = id;

			@Override
			public boolean matches(Object object) {
				final User user = (User) object;
				return expectedId.equals(user.getId());
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("expected result from getId(): ")
				 .appendValue(id);
			}
			
		};
	}
	
}
