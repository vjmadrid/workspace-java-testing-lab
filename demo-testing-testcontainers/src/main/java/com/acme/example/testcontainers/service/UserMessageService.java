package com.acme.example.testcontainers.service;

import java.util.List;

import com.acme.example.testcontainers.entity.UserMessage;

public interface UserMessageService {
	
	List<UserMessage> findAll();

}
