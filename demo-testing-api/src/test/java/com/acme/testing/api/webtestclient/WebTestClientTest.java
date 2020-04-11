package com.acme.testing.api.webtestclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.acme.testing.api.constant.GreetingRestApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebTestClientTest {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	public void whenCallAGetWithMapping_ThenReturnValue() {
	    webTestClient
	      .get()
	      .uri(GreetingRestApiConstant.MAPPING)
	      .accept(MediaType.APPLICATION_JSON)
	      .exchange()
	      .expectStatus().isOk()
	      .expectHeader().contentType(MediaType.APPLICATION_JSON)
	      .expectBody()
	      .jsonPath("$.id").isNotEmpty()
	      .jsonPath("$.content").isNotEmpty();
	  }

}
