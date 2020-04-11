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

import com.acme.testing.api.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserReqResApiClientTest {
	
	@Autowired
	private UserReqResApiClient userReqResApiClient;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenCallAGetFindByIdExternalWithValid_thenReturnUserEntity() throws Exception {

		// Execute : https://reqres.in/api/users/1 -> Value
		User resultEntity = userReqResApiClient.getFindByPK(1L);

		assertNotNull(resultEntity);
		assertEquals(Long.valueOf("1"), resultEntity.getData().getId());
		assertEquals("George", resultEntity.getData().getFirstName());
	}

	@Test(expected = HttpClientErrorException.class)
	public void whenCallAGetFindByIdExternalWithInvalid_thenReturnException() {

		// Execute : https://reqres.in/api/users/1001 -> No Value
		userReqResApiClient.getFindByPK(1001L);
		
	}
	

}
