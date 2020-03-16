package com.acme.testing.mockito.example.test.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.testing.mockito.constant.MessageConstant;
import com.acme.testing.mockito.entity.Message;
import com.acme.testing.mockito.factory.MessageDataFactory;

public class MessageTest {
	
	private Message message;

	private Message anotherMessage;

	private Message cloneMessage;
	
	@Before
	public void init() {
		message = MessageDataFactory.createSampleDefault();
		cloneMessage =  MessageDataFactory.createSampleDefault();
		anotherMessage = MessageDataFactory.createSampleDefault();
		anotherMessage.setId(2L);
	}
	
	@Test
	public void equalsMethodCheckTheType() {
		assertFalse(message.equals("a string"));
	}

	@Test
	public void equalsMethodCheckSameObject() throws Exception {
		assertTrue(message.equals(message));
	}
	
	@Test
	public void equalsMehtodCheckIdField() throws Exception {
		assertFalse(message.equals(anotherMessage));
	}

	@Test
	public void equalsMehtodCheckIdFieldEquals() throws Exception {
		assertTrue(message.equals(cloneMessage));
	}

	@Test
	public void hashproductMethodBasedInTheIDField() throws Exception {
		assertNotSame(message.hashCode(), anotherMessage.hashCode());
	}

	@Test
	public void shouldHaveADescriptiveToStringMethod() {
		assertNotSame(-1, message.toString().indexOf(Message.class.getSimpleName()));
		assertNotSame(-1,
				message.toString().indexOf("id=".concat(MessageConstant.TEST_ID.toString())));
	}

	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(message.getId());
		assertNotNull(message.getValue());
	}

}
