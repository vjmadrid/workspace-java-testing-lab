package com.acme.testing.api.initializer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = { WireMockInitializer.class })
public class WireMockWithSpringInitializerTest {

	private final String TEST_JSON_VALUE = "{\"id\":2,\"content\":\"Hello, Acme!\",\"responseTime\":\"2020-04-10T07:40:04.229+0000\"}";

	private final String TEST_RESULT_CONTENT_VALUE = "Hello, Acme!";

	@Autowired
	private WireMockServer wireMockServer;

	@Autowired
	private WebTestClient webTestClient;

	@LocalServerPort
	private Integer port;

	@Before
	public void setUp() {
		System.out.println("*** SETUP" + "***");
		System.out.println("port Spring :: " + port);
		System.out.println("port WireMockServer :: " + wireMockServer.port());
	}

	@After
	public void tearDown() {
		wireMockServer.resetAll();
	}

	@Test
	public void whenCallASpringPortWithWebTestClient_ThenReturnResult() {

		wireMockServer.stubFor(WireMock.get(GreetingRestApiConstant.MAPPING).willReturn(
				aResponse().withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE).withBody(TEST_JSON_VALUE)));

		webTestClient.get().uri("http://localhost:" + port + GreetingRestApiConstant.MAPPING).exchange().expectStatus()
				.is2xxSuccessful().expectBody().jsonPath("$.id").isEqualTo(1).jsonPath("$.content")
				.isEqualTo("Hello, World!");
	}

	@Test
	public void whenCallAWireMockPortWithWebTestClient_ThenReturnMockResult() {

		wireMockServer.stubFor(WireMock.get(GreetingRestApiConstant.MAPPING).willReturn(
				aResponse().withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE).withBody(TEST_JSON_VALUE)));

		webTestClient.get().uri("http://localhost:" + wireMockServer.port() + GreetingRestApiConstant.MAPPING)
				.exchange().expectStatus().is2xxSuccessful().expectBody().jsonPath("$.id").isEqualTo(2)
				.jsonPath("$.content").isEqualTo(TEST_RESULT_CONTENT_VALUE);
	}

	@Test
	public void whenCallAWireMockErrortWithWebTestClient_ThenReturnMockResult() {
		this.wireMockServer.stubFor(WireMock.get(GreetingRestApiConstant.MAPPING).willReturn(aResponse().withStatus(403)));

		this.webTestClient.get().uri("http://localhost:" + wireMockServer.port() + GreetingRestApiConstant.MAPPING).exchange().expectStatus()
				.isEqualTo(HttpStatus.FORBIDDEN);
	}

}
