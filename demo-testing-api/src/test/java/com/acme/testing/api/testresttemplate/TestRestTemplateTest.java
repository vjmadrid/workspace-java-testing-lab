package com.acme.testing.api.testresttemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.testing.api.constant.GreetingRestApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplateTest {

	private final String TEST_NAME_VALUE = "Acme";
	
	@LocalServerPort
    private int port;

    private URL base;
    
    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
    	
    }

    @Test
    public void whenCallAGetHelloDefault_thenReturnGreetingDefaultBody() throws Exception {
    	
    	String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, GreetingRestApiConstant.DEFAUL_VALUE_PK);
        
    	base = new URL("http://localhost:" + port + GreetingRestApiConstant.MAPPING);
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(EXPECTED_CONTENT_BODY));
    }
    
    @Test
    public void whenCallAGetHelloDefaultWithParameter_thenReturnGreetingBody() throws Exception {
    	
    	String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);
        
    	base = new URL("http://localhost:" + port + GreetingRestApiConstant.MAPPING+"?name="+TEST_NAME_VALUE);
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(EXPECTED_CONTENT_BODY));
    }
    
    @Test
    public void whenCallAGetHelloWithVersionDefault_thenReturnGreetingDefaultBody() throws Exception {
    	
    	String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, GreetingRestApiConstant.DEFAUL_VALUE_PK);
        
    	base = new URL("http://localhost:" + port + GreetingRestApiConstant.MAPPING_WITH_VERSION);
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(EXPECTED_CONTENT_BODY));
    }
    
    @Test
    public void whenCallAGetHelloWithVersionWithParameter_thenReturnGreetingBody() throws Exception {
    	
    	String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);
        
    	base = new URL("http://localhost:" + port + GreetingRestApiConstant.MAPPING_WITH_VERSION+"?name="+TEST_NAME_VALUE);
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(EXPECTED_CONTENT_BODY));
    }
    
    @Test
    public void whenCallAGetHelloWithResponseEntityDefault_thenReturnGreetingDefaultBody() throws Exception {
    	
    	String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, GreetingRestApiConstant.DEFAUL_VALUE_PK);
        
    	base = new URL("http://localhost:" + port + GreetingRestApiConstant.MAPPING_WITH_RESPONSE_ENTITY);
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(EXPECTED_CONTENT_BODY));
    }
    
    @Test
    public void whenCallAGetHelloWithResponseEntityWithVersionWithParameter_thenReturnGreetingBody() throws Exception {
    	
    	String EXPECTED_CONTENT_BODY = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, TEST_NAME_VALUE);
        
    	base = new URL("http://localhost:" + port + GreetingRestApiConstant.MAPPING_WITH_RESPONSE_ENTITY+"?name="+TEST_NAME_VALUE);
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(EXPECTED_CONTENT_BODY));
    }
    
   
	
}
