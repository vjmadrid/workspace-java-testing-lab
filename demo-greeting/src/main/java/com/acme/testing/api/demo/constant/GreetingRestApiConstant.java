package com.acme.testing.api.demo.constant;

public final class GreetingRestApiConstant {

	private GreetingRestApiConstant() {
	}
	
	public static final String MAPPING = "/greeting";
	public static final String MAPPING_WITH_VERSION = "/api/v1/greeting";
	public static final String MAPPING_WITH_RESPONSE_ENTITY = "/greeting/responseentity";
	
	public static final String MAPPING_NAME = "/{name}";
	public static final String MAPPING_NAME_PARAMETER = "name";
	
	public static final String DEFAUL_VALUE_PK = "World";
	
	public static final String TEMPLATE_MESSAGE = "Hello, %s!";
		
}
