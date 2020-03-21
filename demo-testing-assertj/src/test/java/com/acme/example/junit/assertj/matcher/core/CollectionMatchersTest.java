package com.acme.example.junit.assertj.matcher.core;




import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.data.Index;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionMatchersTest {
	
	private String DEFAULT_VALUE = "test";
	
	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	
	
	@Test
	public void shouldBeListMatcher() {
		List<Integer> list = Arrays.asList(1, 5, 10);
		
		assertThat(list).isNotEmpty();
		assertThat(list).hasSize(3);
		assertThat(list).doesNotContainNull();
		
		// assertThat(list).isNotEmpty().hasSize(3).doesNotContainNull();
		
		assertThat(list).contains(5);
		assertThat(list).contains(5,10,1);
		assertThat(list).containsExactly(1,5,10);
		assertThat(list).contains(10, Index.atIndex(2)); //se inicia en 0 el index	 
		assertThat(list).doesNotContainSequence(2,4);
	}
	
	@Test
	public void shouldBeMapMatcher() {
		Map<String, Object> map = new HashMap<>();
        map.put("usuario1", "password1");
        map.put("usuario2", "password2");
		
		assertThat(map).isNotEmpty();
		assertThat(map).hasSize(2);
		
		//assertThat(map).extracting("usuario1").isEqualTo("password1");
	}
	
	
}