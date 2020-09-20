package com.acme.example.testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import com.acme.example.testcontainers.constant.PostgreSQLContainerConstant;
import com.acme.example.testcontainers.constant.UserMessageRestApiConstant;
import com.acme.example.testcontainers.entity.UserMessage;
import com.acme.example.testcontainers.factory.dummy.DummyUserMessageDataFactory;
import com.acme.example.testcontainers.repository.UserMessageRepository;
import com.fasterxml.jackson.databind.node.ArrayNode;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleApplicationIT {

	private static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer(
			PostgreSQLContainerConstant.IMAGE_DOCKER).withDatabaseName(PostgreSQLContainerConstant.DATABASE_NAME)
					.withUsername(PostgreSQLContainerConstant.USERNAME)
					.withPassword(PostgreSQLContainerConstant.PASSWORD).withReuse(true);

	@DynamicPropertySource
	static void datasourceConfig(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
	}

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private UserMessageRepository userMessageRepository;
	
	private List<UserMessage> userMessageListTest;

	@BeforeAll
	public static void beforeAll() {
		postgreSQLContainer.start();
	}
	
	@BeforeEach
	public void setUp() {
		userMessageListTest = DummyUserMessageDataFactory.createSampleList();
		
		this.userMessageRepository.saveAll(userMessageListTest);
	}
	
	@AfterEach
	public void tearDown() {
		this.userMessageRepository.deleteAll();
	}
	
	@Test
	public void shouldBeGetAll() {
		int num_elements = userMessageListTest.size();
		
		ResponseEntity<ArrayNode> result = this.testRestTemplate.getForEntity(UserMessageRestApiConstant.MAPPING, ArrayNode.class);
		
		assertEquals(200, result.getStatusCodeValue());
		assertTrue(result.getBody().isArray());
		assertEquals(num_elements, result.getBody().size());
	}
}
