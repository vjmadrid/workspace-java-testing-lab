package com.acme.example.flyway.service;

import java.util.List;

import com.acme.example.flyway.entity.UserMessage;

public interface UserMessageService {
	
	List<UserMessage> findAll();

}
