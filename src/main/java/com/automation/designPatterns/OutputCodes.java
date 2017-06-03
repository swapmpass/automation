package com.automation.designPatterns;

public class OutputCodes {

	public static void main(String[] args) throws InterruptedException {
		
		int num = 8;
		
		for (int i = num; i >= 1; i--) {
			
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int k = num; k >= i; k--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	

}
