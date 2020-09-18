package com.acme.example.archunit.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;

public class ArchUnitUtil {
	
	protected ArchUnitUtil() {
		throw new IllegalStateException("ArchUnitUtil");
	}

	public static List<Object> generarJavaClassList(final JavaClasses classes) {

		if (classes == null)
			return Collections.emptyList();
		
		return Arrays.asList(classes.toArray());
	}

	public static void showInfo(final JavaClasses classes) {

		if (classes == null)
			System.out.println("Invalid classes");
		else {
			
			List<Object> classesList =  generarJavaClassList(classes);

			System.out.println("Num classes :: "+ classesList.size());
			System.out.println("List classes :: ");
			for (Object value : classesList) {
				JavaClass javaClass = (JavaClass) value;
				System.out.println("* "+javaClass.getFullName());
			}
			
		}
	}	
	
}






 

