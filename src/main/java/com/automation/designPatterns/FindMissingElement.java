package com.automation.designPatterns;

public class FindMissingElement {

	public static void main(String[] args) {

		int arr[] = { 96, 101, 75, 121, 1, 19, 72 };
		
		int sorted_arr[] = sort(arr);

		/*for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {

				System.out.println("i=" + i + "; " + "j=" + j + " :: " + "val-j " + arr[j] + " val i " + arr[i]);

				if (arr[j] > arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}*/

		for (int h = 0; h < sorted_arr.length; h++) {
			System.out.print(sorted_arr[h] + ", ");
		}

	}

	public static int[] sort(int x[]) {
		
		boolean again = false;
		
		int n = x.length;
		
		for (int i = 0; i < n - 1; i++) {
			
			if (x[i] < x[i + 1]) {
				int temp = x[i];
				x[i] = x[i + 1];
				x[i + 1] = temp; // swap values
				again = true;
			}
			
			if (i == n - 2 && again == true) {
				i = 0;
				again = false;
			}
		}
		
		return x;
	}

}
