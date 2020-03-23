package com.acme.testing.api.controller.restassured;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingRestControllerRestAssuredCoreTest {

	private static final String API_PATH = "/api";
	private static final String TEST_NAME_VALUE = "Acme";
	private static final String PATH_DATA_BODY = "content";

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = this.port;
	}

	@Test
	public void whenCallAPIGetValid_thenRetrieveBody() throws Exception {

		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);

		RestAssured.given().accept(ContentType.JSON).when()
				.get(GreetingRestApiConstant.MAPPING+"?name=Acme").then()
				.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
				.body(PATH_DATA_BODY, Matchers.equalTo(EXPECTED_CONTENT_BODY));
	}
	
	@Test
	public void whenCallAPIGetInvalid_thenRetrieve404() throws Exception {

		RestAssured.given().accept(ContentType.JSON).when().get(GreetingRestApiConstant.MAPPING+"/notfound").then()
				.statusCode(HttpStatus.SC_NOT_FOUND);
	}

	@Test
	public void whenCallAPIGetValidWithDetails_thenRetrieveBody() throws Exception {
		
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(GreetingRestApiConstant.MAPPING+"?name=Acme");

		ResponseBody body = response.getBody();
		
		String bodyAsString = body.asString();

		assertTrue(bodyAsString.contains(EXPECTED_CONTENT_BODY));
		
		// No casing
		assertTrue(bodyAsString.toLowerCase().contains(EXPECTED_CONTENT_BODY.toLowerCase()));
	}
	
	@Test
	public void whenCallAPIGetValidWithJsonPath_thenRetrieveContentBody() throws Exception {
		
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);

		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(GreetingRestApiConstant.MAPPING+"?name=Acme");

		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String content = jsonPathEvaluator.get(PATH_DATA_BODY);

		assertEquals(EXPECTED_CONTENT_BODY,content);
	}

}
