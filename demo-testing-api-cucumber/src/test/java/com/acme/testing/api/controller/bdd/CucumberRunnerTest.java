package com.acme.testing.api.controller.bdd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", plugin = { "pretty", "json:target/cucumber-report.json" })
public class CucumberRunnerTest {

	// features : configure directory with contains features files
	// 		Example features = "src/test/resources/features"
	// plugin : configure output plugin
	// 		Example plugin = {"html:target/cucumber-report" }, monochrome = true
	
	// IMPORTANT : Cucumber automatically read all directories where stay this file
	//   * Package : com.acme.testing.api.controller.bdd
	
}
