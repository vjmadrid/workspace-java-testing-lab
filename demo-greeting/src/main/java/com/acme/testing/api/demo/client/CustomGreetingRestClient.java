package com.acme.testing.api.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CustomGreetingRestClient {
	
	@Autowired
	private final RestTemplate customRestTemplate;
	
	public CustomGreetingRestClient(RestTemplate customRestTemplate) {
	    this.customRestTemplate = customRestTemplate;
	  }

	  public JsonNode getGenerateGreeting() {
	    return this.customRestTemplate.getForObject(GreetingRestApiConstant.MAPPING, JsonNode.class);
	  }

}
