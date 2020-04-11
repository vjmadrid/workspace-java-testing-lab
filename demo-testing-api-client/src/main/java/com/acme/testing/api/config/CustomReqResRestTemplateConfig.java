package com.acme.testing.api.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.acme.testing.api.constant.ReqResApiConstant;

@Configuration
public class CustomReqResRestTemplateConfig {
	
	@Bean
	public RestTemplate customRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.rootUri(ReqResApiConstant.ROOT_URI)
				.setConnectTimeout(Duration.ofSeconds(2))
				.setReadTimeout(Duration.ofSeconds(2)).build();
	}

}
