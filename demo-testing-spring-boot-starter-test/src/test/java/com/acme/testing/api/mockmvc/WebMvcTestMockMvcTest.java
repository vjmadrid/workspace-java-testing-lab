package com.acme.testing.api.mockmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.acme.testing.api.config.ComponentScanConfig;
import com.acme.testing.api.demo.constant.GreetingRestApiConstant;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={ComponentScanConfig.class, RestTemplateAutoConfiguration.class})
@WebMvcTest
public class WebMvcTestMockMvcTest {

	private final String TEST_NAME_VALUE = "Acme";
	
	private final String TEST_RESULT_CONTENT_VALUE = "Hello, Acme!";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenCallAGreetingDefault_thenReturnGreetingDefaultBody() throws Exception {
		mockMvc.perform(get(GreetingRestApiConstant.MAPPING)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, " + GreetingRestApiConstant.DEFAUL_VALUE_PK + "!"));
	}

	@Test
	public void whenCallAGreetingDefaultWithParameter_thenReturnGreetingDefaultBody() throws Exception {
		mockMvc.perform(get(GreetingRestApiConstant.MAPPING).param(GreetingRestApiConstant.MAPPING_NAME_PARAMETER,
				TEST_NAME_VALUE)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value(TEST_RESULT_CONTENT_VALUE));
	}

	@Test
	public void whenCallAGreetingWithVersionDefault_thenReturnGreetingDefaultBody() throws Exception {
		mockMvc.perform(get(GreetingRestApiConstant.MAPPING_WITH_VERSION)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, " + GreetingRestApiConstant.DEFAUL_VALUE_PK + "!"));
	}

	@Test
	public void whenCallAGreetingWithVersionWithParameter_thenReturnGreetingDefaultBody() throws Exception {
		mockMvc.perform(get(GreetingRestApiConstant.MAPPING_WITH_VERSION)
				.param(GreetingRestApiConstant.MAPPING_NAME_PARAMETER, TEST_NAME_VALUE)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.content").value(TEST_RESULT_CONTENT_VALUE));
	}
	
	@Test
	public void whenCallAGreetingWithResponseEntityDefault_thenReturnGreetingDefaultBody() throws Exception {
		mockMvc.perform(get(GreetingRestApiConstant.MAPPING_WITH_RESPONSE_ENTITY)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, " + GreetingRestApiConstant.DEFAUL_VALUE_PK + "!"));
	}
	
	@Test
	public void whenCallAGreetingWithResponseEntityWithParameter_thenReturnGreetingDefaultBody() throws Exception {
		mockMvc.perform(get(GreetingRestApiConstant.MAPPING).param(GreetingRestApiConstant.MAPPING_NAME_PARAMETER,
				TEST_NAME_VALUE)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value(TEST_RESULT_CONTENT_VALUE));
	}
	
}
