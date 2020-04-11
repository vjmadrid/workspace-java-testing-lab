package com.acme.testing.api.webclient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import com.acme.testing.api.constant.ReqResApiConstant;
import com.acme.testing.api.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomUserReqResApiWebClientTest {

	@Autowired
	private WebClient customWebClient;
	
	@Test
	public void whenCallAMAPPING_ThenReturnValue() {
		User resultEntity = customWebClient.get().uri(ReqResApiConstant.ROOT_URI+ "/api/users/1")
	      .accept(MediaType.APPLICATION_JSON)
	      .retrieve().bodyToFlux(User.class).blockFirst();
		
		assertNotNull(resultEntity);
		assertEquals(Long.valueOf("2"), resultEntity.getData().getId());
		assertEquals("Hello", resultEntity.getData().getFirstName());
	      
	  }

}
