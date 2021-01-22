package com.acme.example.logcaptor.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.example.logcaptor.service.impl.GreetingServiceImpl;

import nl.altindag.log.LogCaptor;
import nl.altindag.log.model.LogEvent;


public class LogCaptorWithExceptionTest {
	
	private LogCaptor logCaptor;
	
	private GreetingService greetingService;
	
	@BeforeEach
    public void setUp() throws Exception {
		greetingService = new GreetingServiceImpl();
		
		logCaptor = LogCaptor.forClass(GreetingServiceImpl.class);
    }
	
    @AfterEach
    void resetProperties() {
        Optional.ofNullable(logCaptor)
                .ifPresent(LogCaptor::resetLogLevel);
    }
    
    @Test
    public void sayHelloWithException() throws Exception {
    	greetingService.sayHelloWithException();
        
    	List<LogEvent> logEvents = logCaptor.getLogEvents();
    	
        assertThat(logEvents).hasSize(1);

        LogEvent logEvent = logEvents.get(0);
        
        assertThat(logEvent.getMessage()).isEqualTo("Caught unexpected exception");
        assertThat(logEvent.getLevel()).isEqualTo("ERROR");
        assertThat(logEvent.getThrowable()).isPresent();

        assertThat(logEvent.getThrowable().get())
                .hasMessage("Hello World EXCEPTION")
                .isInstanceOf(IOException.class);
    }

}
