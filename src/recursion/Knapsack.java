package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * In the knapsack problem we are given a set of n items, 
 * where each item i is specified by a size s[i] and a value v[i]. 
 * We are also given a size bound S (the size of our knapsack). 
 * The goal is to find the subset of items of maximum total value 
 * such that sum of their sizes is at most S (they all fit into the knapsack).
 *
 */
public class Knapsack {
	static int max = 0;
	
	public static void recurse (int[] value, int[] size, int bound, int start, List<Integer> path) {
		
		if (bound == 0) {
			int val = 0;
			
			for (int index : path) {
				val = val + value[index];
			}
			
			System.out.println(path + " " + val);
			
			max = Math.max(max, val);
			
			return;
		} else if (bound < 0) {
			return;
		}
		
		if (start > size.length-1) return;
		
		int num = size[start];
		
		List<Integer> path1 = new ArrayList<Integer>(path);
		path1.add(start);
		
		List<Integer> path2 = new ArrayList<Integer>(path);
		
		recurse (value, size, bound-num, start+1, path1);
		recurse (value, size, bound, start+1, path2);
		
		
	}
	
	
	public static void main(String[] args) {
		int[] value = {7, 9, 5, 12, 14, 6, 12};
		int[] size =  {3, 4, 2,  6,  7, 3,  5};
		int S = 15;
		recurse (value, size, S, 0, new ArrayList<Integer>());
		System.out.println(max);
	}

}


