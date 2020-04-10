package com.acme.testing.api.annotation.restclienttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.acme.testing.api.client.CustomGreetingRestClient;
import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@RestClientTest(CustomGreetingRestClient.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class CustomGreetingRestClientTest {

	private final String TEST_JSON_VALUE = "{\"id\":2,\"content\":\"Hello, Acme!\",\"responseTime\":\"2020-04-10T07:40:04.229+0000\"}";

	private final String TEST_RESULT_CONTENT_VALUE = "Hello, Acme!";

	@Autowired
	private CustomGreetingRestClient customGreetingRestClient;

	@Autowired
	private MockRestServiceServer mockRestServiceServer;

	@Before
	public void setUp() throws Exception {
		mockRestServiceServer.reset();
	}

	@After
	public void tearDown() {
		mockRestServiceServer.verify();
	}

	@Test
	public void whenCallAGetGenerateGreetingWithCustomClient_thenReturnGreetingBody() throws Exception {

		mockRestServiceServer.expect(requestTo(GreetingRestApiConstant.MAPPING))
				.andRespond(withSuccess(TEST_JSON_VALUE, MediaType.APPLICATION_JSON));

		JsonNode resultJsonNode = customGreetingRestClient.getGenerateGreeting();

		System.out.println("resultJsonNode :: "+resultJsonNode);
		
		assertNotNull(resultJsonNode);
		assertEquals("2", JsonPath.parse(resultJsonNode.toString()).read("$.id", String.class));
		assertEquals(TEST_RESULT_CONTENT_VALUE, JsonPath.parse(resultJsonNode.toString()).read("$.content", String.class));
	}

}
