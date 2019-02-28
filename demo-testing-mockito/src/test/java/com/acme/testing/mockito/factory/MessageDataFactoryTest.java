package com.acme.testing.mockito.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.acme.testing.mockito.constant.MessageConstant;
import com.acme.testing.mockito.entity.Message;
import com.acme.testing.mockito.factory.MessageDataFactory;

public class MessageDataFactoryTest {

	private final int NUM_ELEMENTS = 2;

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateSampleMessage() {
		assertNotNull(MessageDataFactory.createSampleWithId(MessageConstant.TEST_ID, MessageConstant.TEST_VALUE, MessageConstant.TEST_USER, new Date()));
	}

	@Test
	public void shouldCreateSampleMessageDefault() {
		assertNotNull(MessageDataFactory.createSampleDefault());
	}

	@Test
	public void shouldCreateSampleMessageMap() {
		Map<Long, Message> result = MessageDataFactory.createSampleMap();
		
		assertNotNull(result);
		assertEquals(NUM_ELEMENTS,result.size());
	}
	
	@Test
	public void shouldCreateSampleUserList() {
		List<Message> result = MessageDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(NUM_ELEMENTS,result.size());
	}
	
	@Test
	public void shouldCreate() {
		assertNotNull(new MessageDataFactory());
	}

}