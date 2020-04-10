package com.acme.testing.api.controller.restassured.schema;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JsonSchemaGreetingTest {

	private static final String PATH_SCHEMA_VALIDATOR = "schema-greeting.json";

	private static final String PATH_DATA_BODY = "content";

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = this.port;
	}

	@Test
	public void whenCallAGreetingDefault_thenValidateSchemaFile() {

		RestAssured.given().accept(ContentType.JSON).when().get(GreetingRestApiConstant.MAPPING).then().assertThat()
				.body(matchesJsonSchemaInClasspath(PATH_SCHEMA_VALIDATOR));
	}
	
	@Test
	public void whenCallAGreetingDefault_thenValidateSchemaFileWithoutValidation() {

		RestAssured.given().accept(ContentType.JSON).when().get(GreetingRestApiConstant.MAPPING).then().assertThat()
				.body(matchesJsonSchemaInClasspath(PATH_SCHEMA_VALIDATOR).using(
			            settings().with().checkedValidation(false)));
	}
	
	@Test
    public void whenCallAGreetingDefault_thenValidateSchemaFileWithSchemaFactory() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
          .newBuilder()
          .setValidationConfiguration(
            ValidationConfiguration.newBuilder()
              .setDefaultVersion(SchemaVersion.DRAFTV4)
              .freeze()).freeze();

        get(GreetingRestApiConstant.MAPPING)
          .then()
          .assertThat()
          .body(matchesJsonSchemaInClasspath(PATH_SCHEMA_VALIDATOR).using(
            jsonSchemaFactory));
    }

	@Test
	public void whenCallAGreetingDefault_thenReturnGreetingDefaultBody() throws Exception {

		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
				GreetingRestApiConstant.DEFAUL_VALUE_PK);

		get(GreetingRestApiConstant.MAPPING).then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
				.body(PATH_DATA_BODY, Matchers.equalTo(EXPECTED_CONTENT_BODY));
	}

}
