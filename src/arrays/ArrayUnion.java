package arrays;

import java.util.ArrayList;

/*
 * Given two sorted arrays, find the union of the two arrays
 * Union means duplicates should be added only once
 */

public class ArrayUnion {

	public static Integer[] union (int[]arr1, int[] arr2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		
		while (i < arr1.length && j<arr2.length) {
			if (arr2[j] < arr1[i]) {
				res.add(arr2[j]);
				j++;
			} else if (arr1[i] < arr2[j]) {
				res.add(arr1[i]);
				i++;
			} else {
				res.add(arr1[i]);
				i++;
				j++;
			}
		}
		
		
		while (i < arr1.length) {
			res.add(arr1[i]);
			i++;			
		}
		
		while (j < arr2.length) {
			res.add(arr2[j]);
			j++;			
		}		
		
		return res.toArray(new Integer[2]);
	}
	
	
	public static void main(String[] args) {
		int[] arr1 = {1, 4, 6, 8, 9};
		int[] arr2 = {1, 2, 6, 7, 9, 56};
		Integer[] result = union (arr1, arr2);
		
		for (int i=0; i < result.length; i++)
			System.out.print ((int)result[i] + " ");
	}

}
