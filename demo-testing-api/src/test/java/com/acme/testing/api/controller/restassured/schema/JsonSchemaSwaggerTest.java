package com.acme.testing.api.controller.restassured.schema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JsonSchemaSwaggerTest {
	
	private static final String API_PATH_JSON_SWAGGER = "/v2/api-docs";
	private static final String PATH_SCHEMA_VALIDATOR = "/schema/schema-json-v2-api-docs.json";
	
	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = this.port;
	}
	
	@Test
	public void whenCallAJsonSwagger_thenValidateSchemaFile() throws Exception {

		RestAssured.given().accept(ContentType.JSON).when()
				.get(API_PATH_JSON_SWAGGER).then()
				.assertThat()
	            .body(matchesJsonSchemaInClasspath(PATH_SCHEMA_VALIDATOR));
	}
	
}
