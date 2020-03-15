package com.acme.testing.junit5.test.util.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Target({ TYPE, METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("integration")
@Test
public @interface IntegrationTest {

}
