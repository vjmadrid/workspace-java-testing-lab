package com.acme.testing.mockito.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.acme.testing.mockito.constant.MessageConstant;
import com.acme.testing.mockito.entity.Message;
import com.acme.testing.mockito.factory.MessageDataFactory;
import com.acme.testing.mockito.repository.GuasapDao;
import com.acme.testing.mockito.repository.impl.GuasapDaoMapInMemoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class GuasapDaoTest {

	private int NUM_ELEMENTS = 2;
	
	GuasapDao guasapDao;
	
	private Message messageTest;
	
	@Before
	public void setUp() {
		messageTest = MessageDataFactory.createSampleDefault();
		guasapDao= new GuasapDaoMapInMemoryImpl();
		
	}

	@Test
	public void shouldRetrieveAllMessages() {
		final List<Message> resultList = guasapDao.findAll();
		
		assertNotNull(resultList);
		assertEquals(Integer.valueOf(NUM_ELEMENTS), Integer.valueOf(resultList.size()));
	}
	
	@Test
	public void shouldRetrieveMessageById() {
		final Message result = guasapDao.findByPK(MessageConstant.TEST_ID);
		
		assertNotNull(result);
		assertEquals(MessageConstant.TEST_ID, result.getId());
	}
	
	@Test
	public void shouldInsertMessage() {
		final Long newID = Long.valueOf((NUM_ELEMENTS+1));
		
		Date createDate = new Date();
		messageTest.setId(newID);
		messageTest.setCreateDate(createDate);
	
		guasapDao.insert(messageTest);
		
		final Message result = guasapDao.findByPK(newID);
		assertNotNull(result);
		assertEquals(createDate, result.getCreateDate());	
	}
		
	
}