package com.acme.example.testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.acme.example.testcontainers.base.PostgreSQLContainerBase;
import com.acme.example.testcontainers.constant.UserMessageRestApiConstant;
import com.fasterxml.jackson.databind.JsonNode;

public class Example2ApplicationIT extends PostgreSQLContainerBase {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
		ResponseEntity<JsonNode> result = testRestTemplate.getForEntity(UserMessageRestApiConstant.MAPPING,
				JsonNode.class);

		assertEquals(200, result.getStatusCodeValue());
	}

}
