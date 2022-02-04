package recursion;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Find all subsets of an array of numbers
 * 
 * This is NOT the most efficient way to do it. 
 * There is an iterative solution under arrays. 
 */
public class Subsets {
	static HashSet<ArrayList<Integer>> subsets = new HashSet<ArrayList<Integer>>();
		
	public static void recurse (ArrayList<Integer> arr) {
		subsets.add(arr);

		for (int i=0; i < arr.size(); i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(arr);
			temp.remove(i);
			recurse(temp);
		}
	}	
		
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4); arr.add(4); arr.add(4); arr.add(1); arr.add(4); 
		recurse(arr);
		System.out.println(subsets);
	}

}
