package com.acme.testing.api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acme.testing.api.constant.ReqResApiConstant;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CustomUserReqResApiClient {
	
	private final RestTemplate customRestTemplate;
	
	public CustomUserReqResApiClient(RestTemplate reqresRestTemplate) {
	    this.customRestTemplate = reqresRestTemplate;
	  }

	  public JsonNode getFindByPK(Long id) {
	    return this.customRestTemplate.getForObject(ReqResApiConstant.MAPPING_FIND_BY_ID, JsonNode.class, id);
	  }

}
