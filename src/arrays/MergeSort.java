package arrays;

import java.util.ArrayList;

/**
 * Implement Merge Sort
 */
public class MergeSort {

	public static ArrayList<Integer> sort (ArrayList<Integer> arr) {
		if (arr.size() < 2) return arr;
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		int mid = arr.size()/2;
		
		for (int i = 0; i < mid; i++) 
			left.add(arr.get(i));
		
		for (int i = mid; i < arr.size(); i++) 
			right.add(arr.get(i));
				
		return merge (sort (left), sort (right));

	}
	
	public static ArrayList<Integer> merge (ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		int i = 0;
		int j = 0;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while (i < arr1.size() && j < arr2.size()) {
			if (arr1.get(i) < arr2.get(j)) {
				result.add(arr1.get(i));
				i++;
			} else {
				result.add(arr2.get(j));
				j++;				
			}
		}
		
		if (i == arr1.size()) {
			while (j < arr2.size()) {
				result.add(arr2.get(j));
				j++;								
			}
		}
		
		if (j == arr2.size()) {
			while (i < arr1.size()) {
				result.add(arr1.get(i));
				i++;								
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> n = new ArrayList<Integer>();
		n.add(45); n.add(23); n.add(11); n.add(89); n.add(77); n.add(98); n.add(23); 
		n.add(21); n.add(9); n.add(1); n.add(33); n.add(4); n.add(65); n.add(43);
				
		ArrayList<Integer> sortedList = sort(n);
		System.out.print(sortedList);

	}

}
