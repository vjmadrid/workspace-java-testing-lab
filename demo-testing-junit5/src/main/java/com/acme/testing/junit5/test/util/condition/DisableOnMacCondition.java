package com.acme.testing.junit5.test.util.condition;

import org.junit.jupiter.api.condition.OS;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DisableOnMacCondition implements ExecutionCondition {
	
	private final String PROPERTY_OS = "os.name";
	private final String OS_MAC_VALUE = "MAC";
	

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		OS.MAC.name();
		
		String osName = System.getProperty(PROPERTY_OS).toUpperCase();
		
		if (osName.contains(OS_MAC_VALUE)) {
			return ConditionEvaluationResult.disabled("Test disabled on mac");
		} else {
			return ConditionEvaluationResult.enabled("Test enabled");
		}
	}
	
//	public static boolean isWindows() {
//		return (OS.indexOf("win") >= 0);
//	}
//
//	public static boolean isMac() {
//		return (OS.indexOf(OS_MAC_VALUE) >= 0);
//	}
//
//	public static boolean isUnix() {
//		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
//	}
//
//	public static boolean isSolaris() {
//		return (OS.indexOf("sunos") >= 0);
//	}

}
