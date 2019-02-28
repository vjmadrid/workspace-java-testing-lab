package com.acme.testing.mockito.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.testing.mockito.constant.MessageConstant;
import com.acme.testing.mockito.entity.Message;

public final class MessageDataFactory {

	public static Message createSampleWithId(Long id, String value, String user, Date createDate) {
		final Message message = new Message();
		message.setId(id);
		message.setValue(value);
		message.setUser(user);
		message.setCreateDate(createDate);
		return message;
	}

	public static Message createSampleDefault() {
		return createSampleWithId(MessageConstant.TEST_ID, MessageConstant.TEST_VALUE, MessageConstant.TEST_USER,
				new Date());
	}

	public static Map<Long, Message> createSampleMap() {
		final Map<Long, Message> map = new HashMap<>();
		map.put(MessageConstant.TEST_MESSAGE_1_ID,
				createSampleWithId(MessageConstant.TEST_MESSAGE_1_ID, MessageConstant.TEST_MESSAGE_1_VALUE,
						MessageConstant.TEST_MESSAGE_1_USER, new Date()));
		map.put(MessageConstant.TEST_MESSAGE_2_ID,
				createSampleWithId(MessageConstant.TEST_MESSAGE_2_ID, MessageConstant.TEST_MESSAGE_2_VALUE,
						MessageConstant.TEST_MESSAGE_2_USER, new Date()));
		return map;
	}

	public static List<Message> createSampleList() {
		final List<Message> list = new ArrayList<>();
		list.add(createSampleWithId(MessageConstant.TEST_MESSAGE_1_ID, MessageConstant.TEST_MESSAGE_1_VALUE,
				MessageConstant.TEST_MESSAGE_1_USER, new Date()));
		list.add(createSampleWithId(MessageConstant.TEST_MESSAGE_2_ID, MessageConstant.TEST_MESSAGE_2_VALUE,
				MessageConstant.TEST_MESSAGE_2_USER, new Date()));
		return list;
	}

}
