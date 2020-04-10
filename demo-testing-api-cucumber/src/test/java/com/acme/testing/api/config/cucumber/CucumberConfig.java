package com.acme.testing.api.config.cucumber;

import org.junit.Before;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.acme.testing.api.Application;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public class CucumberConfig {
	
	  @Before
	  public void setUp() {
		  System.out.println("*** CUCUMBER CONFIG ***");
	  }

}
