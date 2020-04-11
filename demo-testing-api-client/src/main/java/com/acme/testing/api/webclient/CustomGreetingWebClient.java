package com.acme.testing.api.webclient;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.acme.testing.api.constant.ReqResApiConstant;
import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;

@Service
public class CustomGreetingWebClient {

	private final WebClient customWebClient;

	public CustomGreetingWebClient(WebClient defaultWebClient) {
	    this.customWebClient = defaultWebClient;
	}
	
	public JsonNode getTodoFromAPI() {
	    return customWebClient.get().uri(ReqResApiConstant.MAPPING_FIND_BY_ID)
	      .retrieve()
	      .onStatus(HttpStatus::is4xxClientError, response -> {
	        System.out.println("4xx error");
	        return Mono.error(new RuntimeException("4xx"));
	      })
	      .onStatus(HttpStatus::is5xxServerError, response -> {
	        System.out.println("5xx error");
	        return Mono.error(new RuntimeException("5xx"));
	      })
	      .bodyToMono(JsonNode.class)
	      .block();
	  }

}
