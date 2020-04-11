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
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpClientErrorException;

import com.acme.testing.api.client.UserReqResApiClient;
import com.acme.testing.api.entity.User;
import com.acme.testing.api.factory.UserDataFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@RestClientTest(UserReqResApiClient.class)
public class UserReqResApiRestClientTestTest {

	private final String TEST_JSON_VALUE = "{\"data\": {\"id\": 2,\"first_name\": \"Hello\",\"last_name\": \"World\",\"email\": \"global@email.com\",\"avatar\": \"avatar.jpg\"} }";

	// Use default Rest Template Value
	@Autowired
	private UserReqResApiClient userReqResApiClient;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockRestServiceServer mockRestServiceServer;

	private User userTest;

	@Before
	public void setUp() throws Exception {
		mockRestServiceServer.reset();

		userTest = UserDataFactory.createUser(1001L, "First Name", "Last Name", "emvail@email.com", "avatar");
	}

	@After
	public void tearDown() {
		mockRestServiceServer.verify();
	}

	@Test
	public void whenCallAGetFindByIdMockWithValid_thenReturnUserEntity() throws Exception {

		mockRestServiceServer.expect(requestTo("/api/users/1"))
				.andRespond(withSuccess(TEST_JSON_VALUE, MediaType.APPLICATION_JSON));

		User resultEntity = userReqResApiClient.getFindByPK(1L);

		assertNotNull(resultEntity);

		assertEquals(Long.valueOf("2"), resultEntity.getData().getId());
		assertEquals("Hello", resultEntity.getData().getFirstName());
	}

	@Test
	public void whenCallAGetFindByIdMockObjectMapperWithValid_thenReturnUserEntity() throws Exception {

		String SPECIFIC_JSON = objectMapper.writeValueAsString(userTest);

		mockRestServiceServer.expect(requestTo("/api/users/1001"))
				.andRespond(withSuccess(SPECIFIC_JSON, MediaType.APPLICATION_JSON));

		User resultEntity = userReqResApiClient.getFindByPK(1001L);

		assertEquals(Long.valueOf("1001"), resultEntity.getData().getId());
		assertEquals("First Name", resultEntity.getData().getFirstName());
	}

	@Test(expected = HttpClientErrorException.class)
	public void whenCallAGetFindByIdMockWithInvalid_thenReturnNotFound() {

		mockRestServiceServer.expect(requestTo("/api/users/1001")).andRespond(
				MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON));

		userReqResApiClient.getFindByPK(1001L);
	}

}
