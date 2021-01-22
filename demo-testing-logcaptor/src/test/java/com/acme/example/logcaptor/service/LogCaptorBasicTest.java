package com.acme.example.logcaptor.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.example.logcaptor.service.impl.GreetingServiceImpl;

import nl.altindag.log.LogCaptor;


public class LogCaptorBasicTest {
	
	private static final int NUM_LOGS = 3;
	
	private static final String EXPECTED_INFO_MESSAGE = "Hello World INFO";
	private static final String EXPECTED_WARN_MESSAGE = "Hello World WARN";
	private static final String EXPECTED_ERROR_MESSAGE = "Hello World ERROR";
	
	private LogCaptor logCaptor;
	
	private GreetingService greetingService;
	
	@BeforeEach
    public void setUp() throws Exception {
		greetingService = new GreetingServiceImpl();
		
		logCaptor = LogCaptor.forClass(GreetingServiceImpl.class);
		
		//Level depends logback.xml -> INFO
    }

	@AfterEach
    public void tearDown() {
        logCaptor.clearLogs();
    }
	

    @Test
    public void sayHello_withAssertEntries() throws Exception {
    	greetingService.sayHello();
        
    	assertThat(logCaptor.getInfoLogs()).containsExactly(EXPECTED_INFO_MESSAGE);
    	assertThat(logCaptor.getWarnLogs()).containsExactly(EXPECTED_WARN_MESSAGE);
    }

    @Test
    public void sayHello_withAssertEntriesAndNumber() throws Exception {
    	greetingService.sayHello();
        
    	assertThat(logCaptor.getLogs()).hasSize(NUM_LOGS);
    	
    	assertThat(logCaptor.getLogs())
    	  .hasSize(NUM_LOGS)
    	  .containsExactly(EXPECTED_INFO_MESSAGE, EXPECTED_WARN_MESSAGE,EXPECTED_ERROR_MESSAGE);
    }
    
   

}
