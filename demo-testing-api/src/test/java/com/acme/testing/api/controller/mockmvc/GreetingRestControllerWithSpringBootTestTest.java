package com.acme.testing.api.controller.mockmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acme.testing.api.constant.GreetingRestApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingRestControllerWithSpringBootTestTest {

	private final String TEST_NAME_VALUE = "Acme";

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
				.andExpect(jsonPath("$.content").value("Hello, Acme!"));
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
				.andExpect(status().isOk()).andExpect(jsonPath("$.content").value("Hello, Acme!"));
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
				.andExpect(jsonPath("$.content").value("Hello, Acme!"));
	}
	
	
	
}
