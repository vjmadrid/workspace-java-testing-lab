package com.acme.testing.api.controller.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.acme.testing.api.testing.util.APITestUtil;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GreetingRestControllerWireMockTest {

	private static final String API_PATH = "/api";
	private static final String TEST_NAME_VALUE = "Acme";
	private static final String PATH_DATA_BODY = "content";
	
	private static final String APPLICATION_JSON = "application/json";
	private static final String API_PATH_BODY = getEventJson();

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort().dynamicHttpsPort());

	private static WireMockServer wireMockServer;
	
	private static String getEventJson() {
        return APITestUtil.inputStreamToString(GreetingRestControllerWireMockTest.class
          .getResourceAsStream("/greeting.json"));
    }

	@Before
	public void setUp() throws Exception {
		System.out.println("*** SET UP ***");
		
		//int port = APITestUtil.getAvailablePort();
		int port = wireMockRule.port();
		//int httpsPort = wireMockRule.httpsPort();
		
		System.out.println(" - port :: "+port);
		System.out.println(" - httpsPort :: "+port);

        wireMockServer = new WireMockServer(port);
        wireMockServer.start();
        
        
        configureFor("localhost", port);
        
        //wm.stubFor(get("/thing").willReturn(ok("HTTP/1.1 response")));
        
        stubFor(get(urlEqualTo(GreetingRestApiConstant.MAPPING)).willReturn(
          aResponse().withStatus(200)
            .withHeader("Content-Type", APPLICATION_JSON)
            .withBody(API_PATH_BODY)));
        
        RestAssured.port = port;
	}
	
	@After
    public void tearDown() throws Exception {
        wireMockServer.stop();
    }

	@Test
	public void whenCallAGreetingDefault_thenReturnGreetingDefaultBody() throws Exception {

		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
				GreetingRestApiConstant.DEFAUL_VALUE_PK);

		RestAssured.get(GreetingRestApiConstant.MAPPING).then()
				.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
				.body(PATH_DATA_BODY, Matchers.equalTo(EXPECTED_CONTENT_BODY));
	}
	
	@Test
	public void whenCallAGreetingDefault_thenReturnValidateJson() throws Exception {

		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
				GreetingRestApiConstant.DEFAUL_VALUE_PK);

		RestAssured.get(GreetingRestApiConstant.MAPPING).then()
				.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
				.assertThat()
				.body(matchesJsonSchemaInClasspath("greeting.json"));
	}

	

}
