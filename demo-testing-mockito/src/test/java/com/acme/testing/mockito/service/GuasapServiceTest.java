package com.acme.testing.mockito.service;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.acme.testing.mockito.entity.Message;
import com.acme.testing.mockito.factory.MessageDataFactory;
import com.acme.testing.mockito.repository.GuasapDao;
import com.acme.testing.mockito.service.impl.GuasapServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class GuasapServiceTest {
	
	private GuasapServiceImpl guasapService;
	
	@Mock
	private GuasapDao guasapDao;
	
	private Message messageTest;

	@Before
	public void setUp() {
		messageTest = MessageDataFactory.createSampleDefault();	
		
		guasapService = new GuasapServiceImpl();
		
		when(guasapDao.findByPK(anyLong())).thenReturn(messageTest);
		
		guasapService.setGuasapDao(guasapDao);
	}
	
	@Test
	public void whenCallInsertThenInvokeTheDaoMethod() {
		guasapService.sendMessage(messageTest);
		verify(guasapDao).insert(messageTest);
	}
	
	@Test
	public void whenCallFindAllElementsThenInvokeTheDaoMethod() {
		guasapService.findAllMessages();
		verify(guasapDao).findAll();
	}
	
	@Test
	public void whenCallFindThenInvokeTheDaoMethod() {
		guasapService.findMessage(messageTest.getId());
		verify(guasapDao).findByPK(messageTest.getId());
	}

}
