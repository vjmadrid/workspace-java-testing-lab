package com.acme.testing.junit5.core.execution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.SAME_THREAD)
//@Execution(ExecutionMode.CONCURRENT)
//Other option surefire-plugin-configuration
public class ExecutionParallelTest {

	@Test
	public void shouldBeExcecuteParallelTestA(TestInfo info) throws InterruptedException {
		System.out.println("[@Test] shouldBeExcecuteParallelTestA : Executing  "+ info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

	@Test
	public void shouldBeExcecuteParallelTestB(TestInfo info) throws InterruptedException {
		System.out.println("[@Test] shouldBeExcecuteParallelTestB : Executing  "+ info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

}