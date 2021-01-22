package com.acme.example.logcaptor.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.example.logcaptor.service.impl.GreetingServiceImpl;

import nl.altindag.log.LogCaptor;


public class LogCaptorWithLevelTest {
	
	private static final int NUM_LOGS = 6;
	
	private static final String EXPECTED_TRACE_MESSAGE = "Hello World TRACE";
	private static final String EXPECTED_DEBUG_MESSAGE = "Hello World DEBUG";
	private static final String EXPECTED_INFO_MESSAGE = "Hello World INFO";
	private static final String EXPECTED_WARN_MESSAGE = "Hello World WARN";
	private static final String EXPECTED_ERROR_MESSAGE = "Hello World ERROR";
	
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
    public void clearLogs() {
        logCaptor.clearLogs();
    }
	
    @Test
    public void sayHello_withAssertEntries() throws Exception {
    	greetingService.sayHello();
        
    	assertThat(logCaptor.getInfoLogs()).containsExactly(EXPECTED_INFO_MESSAGE);
    	assertThat(logCaptor.getWarnLogs()).containsExactly(EXPECTED_WARN_MESSAGE);
    	
    	assertThat(logCaptor.getDebugLogs()).containsExactly(EXPECTED_DEBUG_MESSAGE, EXPECTED_DEBUG_CONDITIONAL_MESSAGE);
    }

    @Test
    public void sayHello_withAssertEntriesAndNumber() throws Exception {
    	greetingService.sayHello();
    	
    	assertThat(logCaptor.getLogs()).hasSize(NUM_LOGS);
        
    	assertThat(logCaptor.getLogs())
    	  .hasSize(NUM_LOGS)
    	  .containsExactly(EXPECTED_TRACE_MESSAGE, EXPECTED_DEBUG_MESSAGE, EXPECTED_INFO_MESSAGE, EXPECTED_WARN_MESSAGE,EXPECTED_ERROR_MESSAGE, EXPECTED_DEBUG_CONDITIONAL_MESSAGE);
    }
    
    @Test
    public void sayHello_withAssertEntriesAndNumber_localLevel() throws Exception {
    	logCaptor.setLogLevelToInfo();
    	greetingService.sayHello();
        
    	assertThat(logCaptor.getLogs()).hasSize(3);
    	assertThat(logCaptor.getLogs()).containsExactly(EXPECTED_INFO_MESSAGE, EXPECTED_WARN_MESSAGE, EXPECTED_ERROR_MESSAGE);
    	
    	assertThat(logCaptor.getInfoLogs()).hasSize(1);
    	assertThat(logCaptor.getInfoLogs()).containsExactly(EXPECTED_INFO_MESSAGE);
    	
    	assertThat(logCaptor.getWarnLogs()).hasSize(1);
    	assertThat(logCaptor.getWarnLogs()).containsExactly(EXPECTED_WARN_MESSAGE);
    	
    	assertThat(logCaptor.getDebugLogs()).hasSize(0);
    	assertThat(logCaptor.getDebugLogs()).doesNotContain(EXPECTED_DEBUG_CONDITIONAL_MESSAGE).isEmpty();
   
    }
    
    

}
