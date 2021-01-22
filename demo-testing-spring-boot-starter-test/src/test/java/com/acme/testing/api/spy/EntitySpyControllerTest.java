package com.acme.testing.api.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.acme.testing.api.demo.controller.GreetingRestController;
import com.acme.testing.api.demo.entity.Greeting;

public class EntitySpyControllerTest {
	
	private static final String TEST_NAME_VALUE = "Acme";
	
	private GreetingRestController greetingRestController;

	@BeforeEach
	public final void setUp() throws Exception {
		greetingRestController = spy(new GreetingRestController());
	}
	
	@Test
	public final void whenCallAGreetingDefault_thenReturnGreeting() {
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, "");

		final Greeting response  = greetingRestController.greeting("");
		
		assertNotNull(response);
		assertEquals(EXPECTED_CONTENT_BODY,response.getContent()); 	
	}

	@Test
	public final void whenCallAGreeting_thenReturnGreeting() {
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);

		final Greeting response  = greetingRestController.greeting(TEST_NAME_VALUE);
		
		assertNotNull(response);
		assertEquals(EXPECTED_CONTENT_BODY,response.getContent()); 	
	}
	
	@Test
	public final void whenCallAGreetingWithVersionDefault_thenReturnGreeting() {
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, "");

		final Greeting response  = greetingRestController.greetingWithVersion("");
		
		assertNotNull(response);
		assertEquals(EXPECTED_CONTENT_BODY,response.getContent()); 	
	}
	
	@Test
	public final void whenCallAGreetingWithVersion_thenReturnGreeting() {
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);

		final Greeting response  = greetingRestController.greetingWithVersion(TEST_NAME_VALUE);
		
		assertNotNull(response);
		assertEquals(EXPECTED_CONTENT_BODY,response.getContent()); 	
	}
	
}
