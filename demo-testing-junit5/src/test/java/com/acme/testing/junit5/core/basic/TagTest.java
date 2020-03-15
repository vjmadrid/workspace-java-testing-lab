package com.acme.testing.junit5.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("example")
@Tag("fast")
public class TagTest {
	
	private List<String> testList;

	@Test
	@Tag("method")
	public void shouldBeOneItemList() {
		System.out.println("[@Test] : shouldBeOneItemList");
		
		testList = new ArrayList<String>();

		testList.add("element 1");
		assertEquals(1, testList.size());
		
		testList.clear();
		
	}
	
	//Use with profile maven
	@Test
	@Tag("excludeTag")
	public void excludeTagTest() {
		// no-op
	}

	//Use with profile maven	
	@Test
	@Tag("includeTag")
	public void includeTagTest() {
		// no-op
	}

}