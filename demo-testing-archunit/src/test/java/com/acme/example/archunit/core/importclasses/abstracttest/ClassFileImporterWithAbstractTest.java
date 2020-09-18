package com.acme.example.archunit.core.importclasses.abstracttest;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.acme.example.archunit.user.entity.User;
import com.tngtech.archunit.core.domain.JavaClass;

public class ClassFileImporterWithAbstractTest extends AbstractArchTest {
	
	@Test
    public void shouldBeClassFileImporterShowClassUserPackage() {
		System.out.println("\n *** ClassFileImporterWithAbstract show class User Package ***");

        System.out.println("Get Class info");
        JavaClass clazz = classes.get(User.class);
        System.out.print("User Class :: "+ clazz.getFullName());
   
        assertTrue(Boolean.TRUE);
    }

}

