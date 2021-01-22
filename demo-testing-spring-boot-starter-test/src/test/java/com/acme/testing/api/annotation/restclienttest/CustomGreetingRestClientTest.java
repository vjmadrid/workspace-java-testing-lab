package com.acme.testing.api.annotation.restclienttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.acme.testing.api.config.ComponentScanConfig;
import com.acme.testing.api.demo.client.CustomGreetingRestClient;
import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={ComponentScanConfig.class, RestTemplateAutoConfiguration.class})
@RestClientTest(CustomGreetingRestClient.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class CustomGreetingRestClientTest {

	private final String TEST_JSON_VALUE = "{\"id\":2,\"content\":\"Hello, Acme!\",\"responseTime\":\"2020-04-10T07:40:04.229+0000\"}";

	private final String TEST_RESULT_CONTENT_VALUE = "Hello, Acme!";

	@Autowired
	private CustomGreetingRestClient customGreetingRestClient;
	
	@Autowired
	private MockRestServiceServer mockRestServiceServer;

	@BeforeEach
	public void setUp() throws Exception {
		mockRestServiceServer.reset();
	}

	@AfterEach
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
