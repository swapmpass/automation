package com.automation.designPatterns;

public interface UUU {
	
	int y = 0;
	
	void floa();
	
	void damn();
	
	public static void add() {
		System.out.println("damn it");
	}
	
	UUU f = new UUU() {
		
		@Override
		public void floa() {
			
		}
		
		@Override
		public void damn() {
		}
	};
	
	default UUU getInstance() {
		return f;
	}
}
