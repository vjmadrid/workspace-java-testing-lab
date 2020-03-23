package com.acme.testing.api.controller.restassured;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.testing.api.constant.GreetingRestApiConstant;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingRestControllerRestAssuredApiVersionTest {

	private static final String API_PATH = "/api";
	private static final String API_VERSION_PATH = "/v1";
	private static final String TEST_NAME_VALUE = "Acme";
	private static final String PATH_DATA_BODY = "content";

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = this.port;
	}

	@Test
	public void whenCallAPIGetValid_thenRetrieveNameVersion1InURL() throws Exception {

		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);

		RestAssured.given().accept(ContentType.JSON).when()
				.get(String.format("%s/v1/greeting/?name={name}", API_PATH), TEST_NAME_VALUE).then()
				.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
				.body(PATH_DATA_BODY, Matchers.equalTo(EXPECTED_CONTENT_BODY));
	}
	
	@Test
	public void whenCallAPIGetWithInvalidAPIVersion_thenRetrieve404() throws Exception {

		RestAssured.given().accept(ContentType.JSON).when().get("/api/v2/greeting?name=Acme").then()
				.statusCode(HttpStatus.SC_NOT_FOUND);
	}

}
