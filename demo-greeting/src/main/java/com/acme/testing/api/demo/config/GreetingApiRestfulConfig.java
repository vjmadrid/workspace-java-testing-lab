package com.acme.testing.api.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.testing.api.demo.constant.GreetingApiRestfulConfigConstant;

@Configuration
@ComponentScan(basePackages = { GreetingApiRestfulConfigConstant.GENERIC_PACKAGE })
public class GreetingApiRestfulConfig {

}
