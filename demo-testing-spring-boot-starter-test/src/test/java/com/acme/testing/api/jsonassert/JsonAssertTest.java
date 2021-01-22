package com.acme.testing.api.jsonassert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.acme.testing.api.config.ComponentScanConfig;
import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.jayway.jsonpath.JsonPath;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={ComponentScanConfig.class, RestTemplateAutoConfiguration.class})
@WebMvcTest
public class JsonAssertTest {

	private final String TEST_NAME_VALUE = "Acme";
	
	private final String TEST_RESULT_CONTENT_VALUE = "Hello, Acme!";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenCallAGreetingWithResponseEntityWithParameterWithMvcResultAndJsonPath_thenReturnGreetingDefaultBody() throws Exception {
		
		MvcResult result = mockMvc.perform(get(GreetingRestApiConstant.MAPPING).param(GreetingRestApiConstant.MAPPING_NAME_PARAMETER,
				TEST_NAME_VALUE)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value(TEST_RESULT_CONTENT_VALUE)).andReturn();
		
		String resultString = result.getResponse().getContentAsString();
		
		System.out.println("resultString :: "+resultString);
		
		assertEquals(TEST_RESULT_CONTENT_VALUE, JsonPath.parse(resultString).read("$.content", String.class));
	}
	
	@Test
	public void whenCallAGreetingWithResponseEntityWithParameterWithJsonAssert_thenReturnGreetingDefaultBody() throws Exception {
		
		MvcResult result = mockMvc.perform(get(GreetingRestApiConstant.MAPPING).param(GreetingRestApiConstant.MAPPING_NAME_PARAMETER,
				TEST_NAME_VALUE)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value(TEST_RESULT_CONTENT_VALUE)).andReturn();
		
		String resultString = result.getResponse().getContentAsString();
		
		System.out.println("resultString :: "+resultString);
		
		// When it’s set to false the assertion won’t fail if the JSON contains more fields as expected
		JSONAssert.assertEquals("{\"content\":\"Hello, Acme!\"}", resultString, false);
		
		
	}
	
}
