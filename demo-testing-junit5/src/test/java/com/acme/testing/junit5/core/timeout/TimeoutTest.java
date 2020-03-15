package com.acme.testing.junit5.core.timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TimeoutTest {

	private List<String> testList;
	
	@BeforeEach
	public void setUp() {
		testList = new ArrayList<String>();
	}

	@AfterEach
	public void tearDown() {
		testList.clear();
	}

	@Test
	public void shouldBeOneItemList() {
		System.out.println("[@Test] : shouldBeOneItemList");
		testList.add("element 1");
		
		assertEquals(Integer.valueOf(1), Integer.valueOf(testList.size()));
	}
	
	@Test
	public void shouldBeOneItemListIn3Seconds() {
		System.out.println("[@Test] : shouldBeOneItemListIn3Seconds");
		
		assertTimeout(Duration.ofSeconds(3), ()->{
			testList.add("element 1");
		});
		
		assertEquals(1, testList.size());
	}
	
	@Test
	public void shouldBeOneItemListIn3SecondsWithResult() {
		System.out.println("[@Test] : shouldBeOneItemListIn3SecondsWithResult");
		
		String result = assertTimeout(Duration.ofSeconds(3), ()->{
			testList.add("element 1");
			return "OK";
		});
		
		assertEquals(1, testList.size());
		assertEquals("OK", result);
	}
	
	@Test
	//@Disabled
	void shouldBePerformanceErrorTest() {
		assertTimeout(Duration.ofSeconds(5), () -> {
			for (int i = 0; i <= 1000000; i++) {
				int j = i;
				System.out.println(j);
			}
		});
	}
	
	@Test
	@Disabled
    void shouldBeTimeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            Thread.sleep(100);
        });
    }
	
}