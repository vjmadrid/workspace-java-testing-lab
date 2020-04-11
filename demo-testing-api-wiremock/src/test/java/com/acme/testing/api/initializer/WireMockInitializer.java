package com.acme.testing.api.initializer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

import com.acme.testing.api.constant.GreetingRestApiConstant;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WireMockInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	  @Override
	  public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
	    WireMockServer wireMockServer = new WireMockServer(new WireMockConfiguration().dynamicPort());
	    wireMockServer.start();

	    configurableApplicationContext.getBeanFactory().registerSingleton("wireMockServer", wireMockServer);

	    configurableApplicationContext.addApplicationListener(applicationEvent -> {
	      if (applicationEvent instanceof ContextClosedEvent) {
	        wireMockServer.stop();
	      }
	    });

	    TestPropertyValues
	      .of("greeting_url:http://localhost:" + wireMockServer.port() + GreetingRestApiConstant.MAPPING)
	      .applyTo(configurableApplicationContext);
	  }

}
