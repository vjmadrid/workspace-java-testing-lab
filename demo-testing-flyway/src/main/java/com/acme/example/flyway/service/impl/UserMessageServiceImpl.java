package com.acme.example.flyway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.example.flyway.entity.UserMessage;
import com.acme.example.flyway.repository.UserMessageRepository;
import com.acme.example.flyway.service.UserMessageService;

@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
	
	private final Logger LOG = LoggerFactory.getLogger(UserMessageServiceImpl.class);
	
	@Autowired
	private UserMessageRepository userMessageRepository;

	@Override
	public List<UserMessage> findAll() {
		LOG.trace("Find all UserMessage");
		
		return userMessageRepository.findAll();

	}

}
