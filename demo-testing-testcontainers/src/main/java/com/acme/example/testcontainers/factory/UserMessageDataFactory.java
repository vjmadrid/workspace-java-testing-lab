package com.acme.example.testcontainers.factory;

import java.time.LocalDateTime;

import com.acme.example.testcontainers.entity.UserMessage;

public final class UserMessageDataFactory {

	public static UserMessage create(String description, boolean vip) {
		final UserMessage userMessage = new UserMessage();
		userMessage.setDescription(description);
		userMessage.setVip(vip);
		userMessage.setCreationDate(LocalDateTime.now());
		userMessage.setDeletedDate(null);
		return userMessage;
	}
	
	public static UserMessage create(long id, String description, boolean vip) {
		final UserMessage userMessage = create(description,vip);
		userMessage.setId(id);
		return userMessage;
	}
	
}
