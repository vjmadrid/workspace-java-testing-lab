package com.acme.example.flyway.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acme.example.flyway.entity.UserMessage;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class UserMessageRepository1DirtyTest {
	
	public int TEST_NUM_MESSAGES = 4;

	@Autowired
	private UserMessageRepository userMessageRepository;

	@BeforeEach
	public void setUp() {
		
	}

	@Test
	public void whenCallFindAll_thenReturnElementList() {
		final List<UserMessage> result = userMessageRepository.findAll();

		assertNotNull(result);
		assertThat(result).hasSizeLessThanOrEqualTo(TEST_NUM_MESSAGES);
	}

}
