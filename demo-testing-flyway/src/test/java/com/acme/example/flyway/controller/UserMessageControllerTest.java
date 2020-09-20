package com.acme.example.flyway.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acme.example.flyway.constant.UserMessageRestApiConstant;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class UserMessageControllerTest {
	
	@LocalServerPort
    private int port;

    private URL base;
    
    private String templateMessageTest;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
    	base = new URL("http://localhost:" + port + UserMessageRestApiConstant.MAPPING);
    }

    @Test
    public void getHello() throws Exception {
    	templateMessageTest = String.format("%s,%s","\"id\":1","\"description\":\"Test Description 1\"");
    
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        System.out.println("Response ::"+response);
        
        assertNotNull(template);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertThat(response.getBody(), containsString(templateMessageTest));
    }

}
