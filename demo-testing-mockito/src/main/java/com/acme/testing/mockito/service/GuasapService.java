package com.acme.testing.mockito.service;

import java.util.List;

import com.acme.testing.mockito.entity.Message;

public interface GuasapService {

	boolean sendMessage(final Message message);
	
	List<Message> findAllMessages();
	 
	Message findMessage(Long id);
	
}
