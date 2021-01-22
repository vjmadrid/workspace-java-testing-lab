package com.acme.example.logcaptor.service.impl;



import java.io.IOException;

import org.slf4j.LoggerFactory;

import com.acme.example.logcaptor.service.GreetingService;

import ch.qos.logback.classic.Logger;

public class GreetingServiceImpl implements GreetingService {
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(GreetingServiceImpl.class);

	@Override
	public String sayHello() {
		LOG.trace("Hello World TRACE");
        LOG.debug("Hello World DEBUG");
        LOG.info("Hello World INFO");
        LOG.warn("Hello World WARN");
        LOG.error("Hello World ERROR");
        
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Hello World DEBUG CONDITIONAL");
        }
        
		return "HELLO";
	}
	
	private void generateException() throws IOException {
        throw new IOException("Hello World EXCEPTION");
    }
	
	@Override
	public String sayHelloWithException() {
		try {
            generateException();
        } catch (IOException e) {
            LOG.error("Caught unexpected exception", e);
        }
        
		return "HELLO";
	}
	

}
