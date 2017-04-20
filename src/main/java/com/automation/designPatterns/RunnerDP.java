package com.automation.designPatterns;

public class RunnerDP {
	
	public static void main(String[] args) {
		
		SingeltonClass sc= SingeltonClass.getInstance();
		sc.sayHello();
	}

}
