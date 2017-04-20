package com.automation.designPatterns;

public class SingeltonClass {
	
	private static SingeltonClass currentClass = null;
	
	private SingeltonClass() {
	}
	
	public static SingeltonClass getInstance() {
		
		return currentClass == null ? new SingeltonClass() : currentClass;
	}
	
	public void sayHello() {
		System.out.println("Hello");
	}

}
