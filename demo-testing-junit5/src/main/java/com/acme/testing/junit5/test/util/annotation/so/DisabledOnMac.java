package com.acme.testing.junit5.test.util.annotation.so;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import com.acme.testing.junit5.test.util.condition.DisableOnMacCondition;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DisableOnMacCondition.class)
public @interface DisabledOnMac {
	
}
