package arrays;

import java.util.ArrayList;

/**
 * Common Elements in Two Sorted Arrays 
 */
public class CommonElements {
	public static ArrayList<Integer> common (int[]arr1, int[] arr2) {
		
		int m = arr1.length;
		int n = arr2.length;
		
        ArrayList<Integer> commonList = new ArrayList<Integer>();
        
        int i=0, j=0;
						
		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else if (arr1[i] == arr2[j]) {
				commonList.add(arr1[i]);
				i++;
				j++;
			}
			
		}
				
		return commonList;
	}
	
	
	public static void main(String[] args) {
		int[] arr1 = {1,3,9};
		int[] arr2 = {1,2,3,4,5,6,9};
		System.out.println (common (arr1, arr2));		
	}
}
