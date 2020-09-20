package com.acme.example.testcontainers.base;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import com.acme.example.testcontainers.constant.PostgreSQLContainerConstant;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class PostgreSQLContainerBase {

	static final PostgreSQLContainer postgreSQLContainer;

	static {
		postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer(PostgreSQLContainerConstant.IMAGE_DOCKER)
				.withDatabaseName(PostgreSQLContainerConstant.DATABASE_NAME)
				.withUsername(PostgreSQLContainerConstant.USERNAME).withPassword(PostgreSQLContainerConstant.PASSWORD)
				.withReuse(true);

		postgreSQLContainer.start();
	}

	@DynamicPropertySource
	static void datasourceConfig(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
	}

}
