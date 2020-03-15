package com.acme.testing.junit.exampletdd;

import java.util.GregorianCalendar;

public enum LeapYearValidator {

	INSTANCE;

	public boolean isLeapYearGregorianCalendar(int year) {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.isLeapYear(year);
	}
	
	public boolean isLeapYearCondition1(int year) {
		//Caso 1 : La sentencia de condicional larga
		if ( (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)) )
			return true;
		else
			return false;	
	}
	
	public boolean isLeapYearCondition2(int year) {
		//Caso 2 : Usando operador ternario	
		return ( (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)) )? true: false;
	}
	
	public boolean isLeapYearCondition3(int year) {
		//Caso 3 : La condicion ya devuelve un valor booleano
		return ( (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)) );
	}
	
	private boolean isLeapYearBasicCondition(int year) {
		return ((year % 4 == 0) && (year % 100 != 0));
	}
	
	private boolean isLeapYearAdvanceCondition(int year) {
		return ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0));
	}
	
	public boolean isLeapYearCondition4(int year) {
		//Caso 4 : Extraccion en métodos de condicion	
		return ( isLeapYearBasicCondition(year) || isLeapYearAdvanceCondition(year));
	}
	
	

}
