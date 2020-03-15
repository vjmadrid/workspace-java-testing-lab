package com.acme.testing.junit5.test.util.annotation.so;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@Target({ TYPE, METHOD })
@Retention(RetentionPolicy.RUNTIME)
@EnabledOnOs({OS.LINUX, OS.MAC})
public @interface EnabledOnNixSystems {

}
