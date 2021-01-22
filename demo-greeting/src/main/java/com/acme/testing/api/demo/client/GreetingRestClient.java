package com.acme.testing.api.demo.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.acme.testing.api.demo.entity.Greeting;

@Component
public class GreetingRestClient {
	
	private static final String ROOT_URI = "http://localhost:8091";

	// Use default Spring Rest Template Value
	private final RestTemplate restTemplate;

	public GreetingRestClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.rootUri(ROOT_URI).build();
	}

	public String getGenerateGreetingString() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(GreetingRestApiConstant.MAPPING, HttpMethod.GET, requestEntity, String.class).getBody();
	}
	
	public Greeting getGenerateGreetingEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(GreetingRestApiConstant.MAPPING, HttpMethod.GET, requestEntity, Greeting.class).getBody();
	}

}
