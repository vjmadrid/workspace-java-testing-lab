package com.acme.testing.junit5.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoInjectionTest {
	
	@Mock
	private List<String> mockedList;
	

	private ExampleBoringService exampleBoringService;
	
	public MockitoInjectionTest(@Mock ExampleBoringService service) {
		this.exampleBoringService = service;
	}

	@BeforeEach
	public void setUp() {
	
	}

	@AfterEach
	public void tearDown() {
	}
	
	@Test
	public void shouldCheckVerifyMethod() {
		mockedList.add("test");
		mockedList.clear();

		verify(mockedList).add("test");
		verify(mockedList).clear();
	}
	
	@Test
	public void testConstructorInjectedValue() {
		when(exampleBoringService.getResult()).thenReturn(2);
		
		assertEquals(2, exampleBoringService.getResult());
	}
	
	@Test
	public void testMethodInjection(@Mock ExampleBoringService service) {
		when(service.getResult()).thenReturn(2);
		
		assertEquals(2, service.getResult());
	}

}
