package com.acme.example.logcaptor.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.example.logcaptor.service.impl.GreetingServiceImpl;

import nl.altindag.log.LogCaptor;


public class LogCaptorWithDebugTest {
	
	private static final String EXPECTED_DEBUG_MESSAGE = "Hello World DEBUG";
	private static final String EXPECTED_INFO_MESSAGE = "Hello World INFO";

	private static final String EXPECTED_DEBUG_CONDITIONAL_MESSAGE = "Hello World DEBUG CONDITIONAL";
	
	private LogCaptor logCaptor;
	
	private GreetingService greetingService;
	
	@BeforeEach
    public void setUp() throws Exception {
		greetingService = new GreetingServiceImpl();
		
		logCaptor = LogCaptor.forClass(GreetingServiceImpl.class);
		
        logCaptor.setLogLevelToTrace();
    }
	
    @AfterEach
    void resetProperties() {
        Optional.ofNullable(logCaptor)
                .ifPresent(LogCaptor::resetLogLevel);
    }
    
    @Test
    public void sayHello4() throws Exception {
    	logCaptor.setLogLevelToDebug();
    	greetingService.sayHello();
        
    	assertThat(logCaptor.getInfoLogs()).containsExactly(EXPECTED_INFO_MESSAGE);
    	assertThat(logCaptor.getDebugLogs()).containsExactly(EXPECTED_DEBUG_MESSAGE, EXPECTED_DEBUG_CONDITIONAL_MESSAGE);
    }

}
