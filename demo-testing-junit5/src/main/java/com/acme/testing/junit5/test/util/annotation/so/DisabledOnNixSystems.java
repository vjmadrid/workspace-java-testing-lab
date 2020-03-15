package com.acme.testing.junit5.test.util.annotation.so;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

@Target({ TYPE, METHOD })
@Retention(RetentionPolicy.RUNTIME)
@DisabledOnOs({OS.LINUX, OS.MAC})
public @interface DisabledOnNixSystems {

}