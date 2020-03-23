package com.acme.testing.api.controller.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.acme.testing.api.controller.GreetingRestController;
import com.acme.testing.api.entity.Greeting;

public class GreetingRestControllerTest {
	
	private static final String TEST_NAME_VALUE = "Acme";
	
	private GreetingRestController greetingRestController;

	@Before
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
