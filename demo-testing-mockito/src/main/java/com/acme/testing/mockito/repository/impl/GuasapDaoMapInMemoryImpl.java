package com.acme.testing.mockito.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.testing.mockito.entity.Message;
import com.acme.testing.mockito.factory.MessageDataFactory;
import com.acme.testing.mockito.repository.GuasapDao;

public class GuasapDaoMapInMemoryImpl implements GuasapDao {

	private Map<Long,Message> entityMap = new HashMap<>();
	
	public GuasapDaoMapInMemoryImpl() {
		setEntityMap(MessageDataFactory.createSampleMap());
	}

	@Override
	public void insert(Message message) {
		entityMap.put(message.getId(),message);
	}

	@Override
	public List<Message> findAll() {
		return new ArrayList<Message>(getEntityMap().values());
	}

	@Override
	public Message findByPK(Long id) {
		return getEntityMap().get(id);
	}
	
	public Map<Long,Message> getEntityMap() {
		return entityMap;
	}

	public void setEntityMap(Map<Long,Message> entityMap) {
		this.entityMap = entityMap;
	}

}
