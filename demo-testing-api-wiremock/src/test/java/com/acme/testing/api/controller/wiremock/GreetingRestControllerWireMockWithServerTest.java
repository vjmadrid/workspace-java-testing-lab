package com.acme.testing.api.controller.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.acme.testing.api.testing.util.APITestUtil;
import com.github.tomakehurst.wiremock.WireMockServer;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GreetingRestControllerWireMockWithServerTest {

	private static final String PATH_DATA_BODY = "content";
	
	private static final String FILE_EXAMPLE = "/greeting.json";
	
	private static final String JSON_ORIGIN = getJson(FILE_EXAMPLE);

	private static String getJson(String file) {
		return APITestUtil.inputStreamToString(GreetingRestControllerWireMockTest.class.getResourceAsStream(file));
	}
	
	public int PORT = 8089;
	
	public int HTTPS_PORT;
	
	private static WireMockServer wireMockServer;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("*** SET UP ***");
		wireMockServer = new WireMockServer(wireMockConfig().port(PORT));
		
        wireMockServer.start();
        
        configureFor("localhost", PORT);
        
        // *** Other Configuration **
        //configureFor("wiremock.host", 8090);
        //configureFor("tomcat.host", 8080, "/wiremock");
        
        stubFor(get(urlEqualTo(GreetingRestApiConstant.MAPPING)).willReturn(
          aResponse().withStatus(200)
            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .withBody(JSON_ORIGIN)));
        
        // *** Wild REturn **
        /*
         * 	.willReturn(ok()));
         *  .willReturn(okJson("{ \"message\": \"Test\" }")));
         *  .willReturn(unauthorized()));
         *  .willReturn(status(418)));
         */
        
        RestAssured.port = PORT;
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
	
}
