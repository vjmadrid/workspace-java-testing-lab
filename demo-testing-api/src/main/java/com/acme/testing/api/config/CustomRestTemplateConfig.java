package com.acme.testing.api.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomRestTemplateConfig {
	
	private static final String ROOT_URI = "http://localhost:8091";

	@Bean
	public RestTemplate customRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.rootUri(ROOT_URI)
				.setConnectTimeout(Duration.ofSeconds(2))
				.setReadTimeout(Duration.ofSeconds(2)).build();
	}

}
