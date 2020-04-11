package com.acme.testing.api.factory;

import com.acme.testing.api.entity.User;
import com.acme.testing.api.entity.UserData;

public final class UserDataFactory {

	public static User createUser(Long id,String firstName,String lastName, String email, String avatar) {
		final UserData data = new UserData(id, firstName, lastName, email, avatar);
		data.setId(id);
		data.setFirstName(firstName);
		data.setLastName(lastName);
		data.setEmail(email);
		data.setAvatar(avatar);
		return new User(data) ;
	}

}
