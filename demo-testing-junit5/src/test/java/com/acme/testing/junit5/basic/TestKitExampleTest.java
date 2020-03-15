package com.acme.testing.junit5.basic;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import org.junit.jupiter.api.Test;
import org.junit.platform.testkit.engine.EngineTestKit;
import org.junit.platform.testkit.engine.Events;

public class TestKitExampleTest {
	
	@Test
    void failIfTestsAreSkipped() {
        Events testEvents = EngineTestKit 
            .engine("junit-jupiter") 
            .selectors(selectClass(TestKitTemplateExample.class)) 
            .execute() 
            .tests(); 

        testEvents.assertStatistics(stats -> stats.skipped(1)); 
    }

}
