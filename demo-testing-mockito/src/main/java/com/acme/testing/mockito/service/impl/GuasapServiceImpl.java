package com.acme.testing.mockito.service.impl;

import java.util.List;

import com.acme.testing.mockito.entity.Message;
import com.acme.testing.mockito.repository.GuasapDao;
import com.acme.testing.mockito.service.GuasapService;

public class GuasapServiceImpl implements GuasapService {

	private GuasapDao guasapDao;
	
	@Override
	public boolean sendMessage(Message message) {
		guasapDao.insert(message);
		return true;
	}
	
	@Override
	public List<Message> findAllMessages() {
		return guasapDao.findAll();
	}

	@Override
	public Message findMessage(Long id) {
		return guasapDao.findByPK(id);
	}

	public void setGuasapDao(GuasapDao guasapDao) {
		this.guasapDao = guasapDao;
	}
	
}
