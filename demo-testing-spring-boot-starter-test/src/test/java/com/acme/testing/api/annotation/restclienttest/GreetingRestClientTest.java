package com.acme.testing.api.annotation.restclienttest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpClientErrorException;

import com.acme.testing.api.config.ComponentScanConfig;
import com.acme.testing.api.demo.client.GreetingRestClient;
import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.acme.testing.api.demo.entity.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes={ComponentScanConfig.class, RestTemplateAutoConfiguration.class}) //Use external API project
@ContextConfiguration(classes={ComponentScanConfig.class}) //Use internal API project
@RestClientTest(GreetingRestClient.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class GreetingRestClientTest {

	private final String TEST_JSON_VALUE = "{\"id\":2,\"content\":\"Hello, Acme!\",\"responseTime\":\"2020-04-10T07:40:04.229+0000\"}";

	private final String TEST_RESULT_CONTENT_VALUE = "Hello, Acme!";

	// Use default Rest Template Value
	@Autowired
	private GreetingRestClient greetingRestClient;

	@Autowired
	private ObjectMapper objectMapper;

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
	public void whenCallAGetGenerateGreetingStringWithClient_thenReturnGreetingBody() throws Exception {

		mockRestServiceServer.expect(requestTo(GreetingRestApiConstant.MAPPING))
				.andRespond(withSuccess(TEST_JSON_VALUE, MediaType.APPLICATION_JSON));

		String resultString = greetingRestClient.getGenerateGreetingString();

		assertNotNull(resultString);
		assertEquals("2", JsonPath.parse(resultString).read("$.id", String.class));
		assertEquals(TEST_RESULT_CONTENT_VALUE, JsonPath.parse(resultString).read("$.content", String.class));
	}

	@Test
	public void whenCallAGetGenerateGreetingStringWithClient_thenReturnSpecificGreetingBody() throws Exception {

		String SPECIFIC_JSON = objectMapper.writeValueAsString(new Greeting(1001, TEST_RESULT_CONTENT_VALUE));

		mockRestServiceServer.expect(requestTo(GreetingRestApiConstant.MAPPING))
				.andRespond(withSuccess(SPECIFIC_JSON, MediaType.APPLICATION_JSON));

		String resultString = greetingRestClient.getGenerateGreetingString();

		assertNotNull(resultString);
		assertEquals("1001", JsonPath.parse(resultString).read("$.id", String.class));
		assertEquals(TEST_RESULT_CONTENT_VALUE, JsonPath.parse(resultString).read("$.content", String.class));
	}

	@Test
	public void whenCallAGetGenerateGreetingStringWithClient_thenReturnNotFound() {

		assertThrows(HttpClientErrorException.class, () -> {
			mockRestServiceServer.expect(requestTo(GreetingRestApiConstant.MAPPING))
					.andRespond(MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND));

			greetingRestClient.getGenerateGreetingString();
		});

	}

	@Test
	public void whenCallAGetGenerateGreetingEntityWithClient_thenReturnSpecificGreetingBody() throws Exception {

		String SPECIFIC_JSON = objectMapper.writeValueAsString(new Greeting(1001, TEST_RESULT_CONTENT_VALUE));

		mockRestServiceServer.expect(requestTo(GreetingRestApiConstant.MAPPING))
				.andRespond(withSuccess(SPECIFIC_JSON, MediaType.APPLICATION_JSON));

		Greeting resultEntity = greetingRestClient.getGenerateGreetingEntity();

		assertNotNull(resultEntity);
		assertEquals(1001L, resultEntity.getId());
		assertEquals(TEST_RESULT_CONTENT_VALUE, resultEntity.getContent());
	}

}
