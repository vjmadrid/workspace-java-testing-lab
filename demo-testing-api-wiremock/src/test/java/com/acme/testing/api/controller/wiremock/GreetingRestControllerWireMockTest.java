package com.acme.testing.api.controller.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import java.net.URL;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.acme.testing.api.testing.util.APITestUtil;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GreetingRestControllerWireMockTest {

	private static final String PATH_DATA_BODY = "content";
	
	private static final String FILE_EXAMPLE = "/greeting.json";
	
	private static final String JSON_ORIGIN = getJson(FILE_EXAMPLE);

	private static String getJson(String file) {
		return APITestUtil.inputStreamToString(GreetingRestControllerWireMockTest.class.getResourceAsStream(file));
	}
	
	public int PORT;
	
	public int HTTPS_PORT;
	
	private URL base;
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort().dynamicHttpsPort());


	@Before
	public void setUp() throws Exception {
		PORT = wireMockRule.port();
		HTTPS_PORT = wireMockRule.httpsPort();
	}
	
	@After
    public void tearDown() throws Exception {
      
    }

	@Test
	public void whenCallAGreetingDefault_thenReturnGreetingDefaultBody() throws Exception {

		base = new URL("http://localhost:" + PORT + GreetingRestApiConstant.MAPPING);

		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
				GreetingRestApiConstant.DEFAUL_VALUE_PK);
		
		stubFor(get(urlEqualTo(GreetingRestApiConstant.MAPPING)).willReturn(okJson(JSON_ORIGIN)));

		RestAssured.get(base.toString()).then()
				.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
				.body(PATH_DATA_BODY, Matchers.equalTo(EXPECTED_CONTENT_BODY));
	}
	
}
