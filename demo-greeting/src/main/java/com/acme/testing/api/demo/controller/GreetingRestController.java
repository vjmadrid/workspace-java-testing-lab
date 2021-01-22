package com.acme.testing.api.demo.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.testing.api.demo.constant.GreetingRestApiConstant;
import com.acme.testing.api.demo.entity.Greeting;

@RestController
public class GreetingRestController {
	
	public static final Logger LOG = LoggerFactory.getLogger(GreetingRestController.class);

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = GreetingRestApiConstant.MAPPING, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    public Greeting greeting(@RequestParam(value=GreetingRestApiConstant.MAPPING_NAME_PARAMETER, defaultValue=GreetingRestApiConstant.DEFAUL_VALUE_PK) String name) {
    	LOG.info("Greeting ...");
    	LOG.info("[*] Name {}",name);
    	
    	return new Greeting(counter.incrementAndGet(),String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, name));
    }
    
    @GetMapping(GreetingRestApiConstant.MAPPING_WITH_VERSION)
	@ResponseStatus(HttpStatus.OK)
    public Greeting greetingWithVersion(@RequestParam(value=GreetingRestApiConstant.MAPPING_NAME_PARAMETER, defaultValue=GreetingRestApiConstant.DEFAUL_VALUE_PK) String name) {
    	LOG.info("Greeting with Version ...");
    	LOG.info("[*] Name {}",name);
    	
    	return new Greeting(counter.incrementAndGet(),String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, name));
    }
    
    @GetMapping(GreetingRestApiConstant.MAPPING_WITH_RESPONSE_ENTITY)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Greeting> greetingWithResponseEntity(@RequestParam(value=GreetingRestApiConstant.MAPPING_NAME_PARAMETER, defaultValue=GreetingRestApiConstant.DEFAUL_VALUE_PK) String name) {
    	LOG.info("Greeting with Response Entity ...");
    	LOG.info("[*] Name {}",name);
    	
    	return ResponseEntity.ok(new Greeting(counter.incrementAndGet(),String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, name)));
    }
    
    
}
