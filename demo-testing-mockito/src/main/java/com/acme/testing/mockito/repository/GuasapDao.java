package com.acme.testing.mockito.repository;

import java.util.List;

import com.acme.testing.mockito.entity.Message;

public interface GuasapDao {
	   
	void insert(Message message);
	
	List<Message> findAll();
	
	Message findByPK(Long id);
	
}

