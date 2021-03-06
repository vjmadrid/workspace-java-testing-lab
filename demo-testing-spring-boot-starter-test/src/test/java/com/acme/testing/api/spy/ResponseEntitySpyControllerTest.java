package com.acme.testing.api.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.acme.testing.api.demo.controller.GreetingRestController;
import com.acme.testing.api.demo.entity.Greeting;

public class ResponseEntitySpyControllerTest {

	private static final String TEST_NAME_VALUE = "Acme";

	private GreetingRestController greetingRestController;

	@BeforeEach
	public final void setUp() throws Exception {
		greetingRestController = spy(new GreetingRestController());
	}

	@Test
	public final void whenCallAGreetingWithResponseEntityDefault_thenReturnGreeting() {
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, "");

		final ResponseEntity<Greeting> responseEntity = greetingRestController.greetingWithResponseEntity("");

		assertNotNull(responseEntity);
		assertEquals(EXPECTED_CONTENT_BODY, responseEntity.getBody().getContent());
	}

	@Test
	public final void whenCallAGreetingWithResponseEntity_thenReturnGreeting() {
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);

		final ResponseEntity<Greeting> responseEntity = greetingRestController
				.greetingWithResponseEntity(TEST_NAME_VALUE);

		assertNotNull(responseEntity);
		assertEquals(EXPECTED_CONTENT_BODY, responseEntity.getBody().getContent());
	}

}
