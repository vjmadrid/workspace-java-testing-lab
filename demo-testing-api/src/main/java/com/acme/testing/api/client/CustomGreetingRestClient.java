package com.acme.testing.api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CustomGreetingRestClient {
	
	private final RestTemplate customRestTemplate;
	
	public CustomGreetingRestClient(RestTemplate reqresRestTemplate) {
	    this.customRestTemplate = reqresRestTemplate;
	  }

	  public JsonNode getGenerateGreeting() {
	    return this.customRestTemplate.getForObject(GreetingRestApiConstant.MAPPING, JsonNode.class);
	  }

}
