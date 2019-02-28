package com.acme.testing.mockito.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.acme.testing.mockito.entity.Message;
import com.acme.testing.mockito.factory.MessageDataFactory;
import com.acme.testing.mockito.repository.GuasapDao;

public class GuasapDaoListInMemoryImpl implements GuasapDao {

	private List<Message> entityList = new ArrayList<Message>();

	public GuasapDaoListInMemoryImpl() {
		setEntityList(MessageDataFactory.createSampleList());
	}
	
	@Override
	public final void insert(final Message object) {
		entityList.add(object);
	}

	@Override
	public final List<Message> findAll() {
		return entityList;
	}

	@Override
	public final Message findByPK(final Long id) {
		if (entityList.isEmpty()) {
			return null;
		}
		return entityList.get(0);
	}

	public List<Message> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Message> entityList) {
		this.entityList = entityList;
	}

}
