package com.acme.testing.api.controller.httpclient;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.testing.api.constant.GreetingRestApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingRestControllerWithHttpClientTest {

	private final String TEST_NAME_VALUE = "Acme";

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void whenCallAGetHelloDefault_thenReturnGreetingDefaultBody() throws Exception {

		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
				GreetingRestApiConstant.DEFAUL_VALUE_PK);

		base = new URL("http://localhost:" + port + GreetingRestApiConstant.MAPPING);
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);

		assertThat(response.getBody(), containsString(EXPECTED_CONTENT_BODY));
	}

	@Test	
    public void whenCallAGetHelloDefaultWithHttpClient_thenReturnGreetingDefaultBody() throws ClientProtocolException, IOException  {
		String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE,
				GreetingRestApiConstant.DEFAUL_VALUE_PK);
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		String GET_ENPOINT = "http://localhost:" + port + GreetingRestApiConstant.MAPPING;

		HttpGet httpget = new HttpGet(GET_ENPOINT);
		System.out.println("Executing request " + httpget.getRequestLine());
		
		HttpResponse response = httpclient.execute(httpget);
		
		//assertThat(response.getEntity().getContent().toString(), containsString(EXPECTED_CONTENT_BODY));
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));
		
		//Throw runtime exception if status code isn't 200
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "+ response.getStatusLine().getStatusCode());
		}
		
		//Create the StringBuffer object and store the response into it.
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println("Response : \n"+result.append(line));
		}
		
		assertThat(result.toString(), containsString(EXPECTED_CONTENT_BODY));
	}


}
