package com.acme.testing.api.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomUserReqResApiClientTest {
	
	@Autowired
	private CustomUserReqResApiClient customUserReqResApiClient;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenCallAGetFindByIdExternalWithValid_thenReturnUserEntity() throws Exception {

		// Execute : https://reqres.in/api/users/1 -> Value
		JsonNode resultJsonNode = customUserReqResApiClient.getFindByPK(1L);
		
		System.out.println("resultJsonNode :: "+resultJsonNode);
		
		assertNotNull(resultJsonNode);
		assertEquals("1", JsonPath.parse(resultJsonNode.toString()).read("$.data.id", String.class));
		assertEquals("George", JsonPath.parse(resultJsonNode.toString()).read("$.data.first_name", String.class));
	}

	@Test(expected = HttpClientErrorException.class)
	public void whenCallAGetFindByIdExternalWithInvalid_thenReturnException() {

		// Execute : https://reqres.in/api/users/1001 -> No Value
		customUserReqResApiClient.getFindByPK(1001L);
		
	}
	

}
