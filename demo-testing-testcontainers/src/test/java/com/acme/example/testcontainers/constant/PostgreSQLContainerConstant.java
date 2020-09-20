package com.acme.example.testcontainers.constant;

public final class PostgreSQLContainerConstant {


	private PostgreSQLContainerConstant() {
	}

	public static final String IMAGE_DOCKER = "postgres:10-alpine";
	
	public static final String DATABASE_NAME = "acme";
	public static final String USERNAME = "admin";
	public static final String PASSWORD = "1234";
	
}
