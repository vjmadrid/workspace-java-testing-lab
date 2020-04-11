package com.acme.testing.api.controller.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.Options.DYNAMIC_PORT;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.acme.testing.api.testing.util.APITestUtil;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WireMockBasicTest {

	private static WireMockServer wireMockServer;


	@Before
	public void setUp() throws Exception {
//		wireMockServer = new WireMockServer(DYNAMIC_PORT);
//		wireMockServer.start();
//		
//		//int port = wireMockRule.port();
//		
//		int port = APITestUtil.getAvailablePort();
//		
//		int httpsPort = wireMockRule.httpsPort();
//
//        wireMockServer = new WireMockServer(port);
//        wireMockServer.start();
//        
//        
//        configureFor("localhost", port);
//        
//        //wm.stubFor(get("/thing").willReturn(ok("HTTP/1.1 response")));
//        
//        stubFor(get(urlEqualTo(GreetingRestApiConstant.MAPPING)).willReturn(
//          aResponse().withStatus(200)
//            .withHeader("Content-Type", APPLICATION_JSON)
//            .withBody(API_PATH_BODY)));
        
        //RestAssured.port = port;
	}
	
	@After
    public void tearDown() throws Exception {
        //wireMockServer.stop();
    }
	
	@Test
    public void returnsOptionsWhenCallingGetOptions() {
        Options options = new WireMockConfiguration();
        WireMockServer wireMockServer = new WireMockServer(options);
        
        assertThat(wireMockServer.getOptions()).isEqualTo(options);
    }

//	@Test
//	public void whenCallAGreetingDefault_thenReturnGreetingDefaultBody() throws Exception {
//
//		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
//				GreetingRestApiConstant.DEFAUL_VALUE_PK);
//
//		RestAssured.get(GreetingRestApiConstant.MAPPING).then()
//				.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
//				.body(PATH_DATA_BODY, Matchers.equalTo(EXPECTED_CONTENT_BODY));
//	}
//	
//	@Test
//	public void whenCallAGreetingDefault_thenReturnValidateJson() throws Exception {
//
//		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
//				GreetingRestApiConstant.DEFAUL_VALUE_PK);
//
//		RestAssured.get(GreetingRestApiConstant.MAPPING).then()
//				.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
//				.assertThat()
//				.body(matchesJsonSchemaInClasspath("greeting.json"));
//	}

	

}
