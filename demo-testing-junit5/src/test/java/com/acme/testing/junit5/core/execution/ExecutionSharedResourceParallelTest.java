package com.acme.testing.junit5.core.execution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

public class ExecutionSharedResourceParallelTest {

	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ_WRITE)
	public void shouldBeReadWriteTestA(TestInfo info) throws InterruptedException {
		System.out.println("[@Test] shouldBeReadWriteTestA : Executing  "+ info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ_WRITE)
	public void shouldBeReadWriteTestB(TestInfo info) throws InterruptedException {
		System.out.println("[@Test] shouldBeReadWriteTestB : Executing  "+ info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}
	
	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ)
	public void shouldBeReadOnlyTestA(TestInfo info) throws InterruptedException {
		System.out.println("[@Test] shouldBeReadOnlyTestA : Executing  "+ info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}

	@Test
	@ResourceLock(value = "UNIQUE_RESOURCE", mode = ResourceAccessMode.READ)
	public void shouldBeReadOnlyTestB(TestInfo info) throws InterruptedException {
		System.out.println("[@Test] shouldBeReadOnlyTestB : Executing  "+ info.getDisplayName() + " on thread: " + Thread.currentThread());
		Thread.sleep(2000L);
	}
}
