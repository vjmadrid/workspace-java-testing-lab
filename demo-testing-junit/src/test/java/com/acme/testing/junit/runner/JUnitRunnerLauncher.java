package com.acme.testing.junit.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.acme.testing.junit.core.basic.BasicTest;

public class JUnitRunnerLauncher {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(BasicTest.class);
		
		for (Failure fail : result.getFailures()) {
			System.out.println(fail.toString());
		}
		
		if (result.wasSuccessful()) {
			System.out.println("All tests finished successfully...");
		}
	}
	
}
