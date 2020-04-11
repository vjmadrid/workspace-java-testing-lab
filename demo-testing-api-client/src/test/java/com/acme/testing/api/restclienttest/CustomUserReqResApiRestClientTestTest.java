package com.acme.testing.api.restclienttest;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpClientErrorException;

import com.acme.testing.api.client.CustomUserReqResApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@RestClientTest(CustomUserReqResApiClient.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class CustomUserReqResApiRestClientTestTest {

	private final String TEST_JSON_VALUE = 
		      "{\"data\": {\"id\": 1,\"first_name\": \"Hello\",\"last_name\": \"World\",\"email\": \"global@email.com\",\"avatar\": \"avatar.jpg\"} }";
		
	@Autowired
	private CustomUserReqResApiClient customUserReqResApiClient;

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
	public void whenCallAGetFindByIdMockWithClient_thenReturnUserEntity() throws Exception {

		mockRestServiceServer.expect(requestTo("/api/users/1"))
				.andRespond(withSuccess(TEST_JSON_VALUE, MediaType.APPLICATION_JSON));

		JsonNode resultJsonNode = customUserReqResApiClient.getFindByPK(1L);

		System.out.println("resultJsonNode :: "+resultJsonNode);
		
		assertNotNull(resultJsonNode);
		assertEquals("1", JsonPath.parse(resultJsonNode.toString()).read("$.data.id", String.class));
		assertEquals("Hello", JsonPath.parse(resultJsonNode.toString()).read("$.data.first_name", String.class));
	}
	
	@Test(expected = HttpClientErrorException.class)
	public void whenCallAGetFindByIdMockWithInvalid_thenReturnNotFound() {

		mockRestServiceServer.expect(requestTo("/api/users/1001"))
				.andRespond(
						MockRestResponseCreators.
						withStatus(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON));

		customUserReqResApiClient.getFindByPK(1001L);
	}

}
