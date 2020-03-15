package com.acme.testing.junit5.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.acme.testing.junit5.LinearSearcher;

public class LinearSearcherTest {
	
	private static LinearSearcher searcher;
	
    @BeforeAll
    public static void setUp(){
       int[] array = {1, 2, 3, 4, 5, 6};
       
       searcher = new LinearSearcher(array);
    }
    
    @AfterAll
    public static void tearDown(){

    }
    
    @Test
    public void whenCallAGetPosition_ThenReturnPosition(){
       int result = searcher.getPosition(3);
       
       Assertions.assertEquals(2,result);
    }
    
    @Test
    public void whenCallAGetPosition_ThenReturnNoPosition(){
       int result = searcher.getPosition(7);
       
       Assertions.assertEquals(-1, result);
    }
    
   

}
