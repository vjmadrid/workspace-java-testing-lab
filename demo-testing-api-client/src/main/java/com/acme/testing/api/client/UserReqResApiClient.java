package com.acme.testing.api.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acme.testing.api.constant.ReqResApiConstant;
import com.acme.testing.api.entity.User;

@Component
public class UserReqResApiClient {

	// Use default Spring Rest Template Value
	private final RestTemplate restTemplate;

	public UserReqResApiClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.rootUri(ReqResApiConstant.ROOT_URI).build();
	}

	public User getFindByPK(Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(ReqResApiConstant.MAPPING_FIND_BY_ID, HttpMethod.GET, requestEntity, User.class, id)
				.getBody();
	}

}
