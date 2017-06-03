package com.automation.designPatterns;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

public class FindMissingElement {
	
	public static void main(final String[] args) {
		
		// Hashtable<K, V>
		// HashMap<K, V>
		// HashSet<E>
		// TreeMap<K, V>
		// Tree
		
		final TreeMap<String, String> tm = new TreeMap<>();
		tm.put(null, null);
		
		final HashMap<String, String> hm = new HashMap<>();
		hm.put(null, null);
		
		final Hashtable<String, String> ht = new Hashtable<>();
		ht.put(null, null);
		
		final LinkedList<String> ll = new LinkedList<>();
		
		final int arr[] = { 96, 101, 75, 121, 1, 19, 72 };
		
		// final int sorted_arr[] = sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				// System.out.println("i=" + i + "; " + "j=" + j + " :: " +
				// "val-j " + arr[j] + " val i " + arr[i]);
				if (arr[j] > arr[i]) {
					final int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		/*- for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j--) {
				System.out.println("i=" + i + "; " + "j=" + j + " :: " + "val-j " + arr[j] + " val i " + arr[i]);
				if (arr[j] > arr[i]) {
					final int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}*/
		
		for (final int element : arr) {
			System.out.print(element + ", ");
		}
		
	}
	
	public static int[] sort(final int x[]) {
		
		boolean again = false;
		
		final int n = x.length;
		
		for (int i = 0; i < n - 1; i++) {
			
			if (x[i] < x[i + 1]) {
				final int temp = x[i];
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
