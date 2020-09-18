
package com.acme.testing.api.jsonpath;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.testing.api.util.APITestUtil;
import com.jayway.jsonpath.JsonPath;

/*
 *  Use for check : https://jsonpath.com/
 *  
 *  	$ 			: Root Object or Array
 *  	@			: Actual node
 *  	.property 	: Specified property
 *  	..property  : Descendent recursive 
 *  	[n]			: n element from array (0-based) and selects elements with ","
 *  
 *  		[start:end]
 *			[start:]	
 *			[:n]		: First Elements -> Return a List
 *			[-n:]		: Last Elements -> Return a List
 *  
 *  	*			: Wildcard for select all elements
 *  	[?(expression)] : Filter expression for object or array -> Return a List
 *  		Use value or other field
 *  
 *  			== equals (String use "'" ->  'value') or != not equals
 *  			>=, > , < or <=
 *  			=~ JavaScript regular expresion
 *  			! Negate
 *  				[?(!@.property)] : No Content
 *  			&&
 *  				[?(@.name=='Test' && @.price > 100)]
 *  			||
 *  
 *  	IMPORTANT :
 *  
 *  		JSONPath expressions, including property names and values, are case-sensitive.
 *  
 *  		Unlike XPath, JSONPath does not have operations for accessing parent or sibling nodes from the given node.
 */

@RunWith(SpringRunner.class)
public class JsonPathWithFileTest {

	private static final String FILE_EXAMPLE = "/example.json";
	
	private static final String JSON_ORIGIN = getJson(FILE_EXAMPLE);

	private static String getJson(String file) {
		return APITestUtil.inputStreamToString(JsonPathWithFileTest.class.getResourceAsStream(file));
	}
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void whenCallARead_ThenRerturnValue() throws Exception {
		
		String value = JsonPath.parse(JSON_ORIGIN).read("$.address.city").toString();

		assertEquals("Nara", value);
	}
	
	@Test
	public void whenCallAReadWithNotation_ThenRerturnValue() throws Exception {
		
		String value = JsonPath.parse(JSON_ORIGIN).read("$.['address'].city").toString();

		assertEquals("Nara", value);
	}
	
	@Test
	public void whenCallAReadWithArray_ThenRerturnValue() throws Exception {
		
		String valueWithArray = JsonPath.parse(JSON_ORIGIN).read("$['phoneNumbers'][:1].['type']").toString();

		assertEquals("[\"iPhone\"]", valueWithArray);
	}
	
	@Test
	public void whenCallAFilter_ThenRerturnValue() throws Exception {
		
		String value = JsonPath.parse(JSON_ORIGIN).read("$.phoneNumbers[?(!@.vip)]").toString();

		System.out.println(value);
		
		assertEquals("[{\"type\":\"home\",\"number\":\"0123-4567-8910\"}]", value);
	}
	
	@Test
	public void whenCallAWildcard_ThenRerturnValue() throws Exception {
		
		String value = JsonPath.parse(JSON_ORIGIN).read("$.phoneNumbers[*].number").toString();

		System.out.println(value);
		
		assertEquals("[\"0123-4567-8888\",\"0123-4567-8910\"]", value);
	}
	
	
}

