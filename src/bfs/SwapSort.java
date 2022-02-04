package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given an array in which all elements are unique. You can only use swap operation. 
 * What is the minimum steps you will need to sort this array in ascending order? Also print path.
 * 
 * Input: [1, 2, 3, 4] 
 * Output: { } means empty path. We don't need to sort.
 * 
 * Input: [3, 4, 1, 2] 
 * Output {3412, 1432, 1234} we need to swap 2 times.
 *
 */
public class SwapSort {
	
	public static int sort (int[] nums) {
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<Integer> levels = new LinkedList<Integer>();
		Queue<List<int[]>> paths = new LinkedList<List<int[]>>();
		
		q.add(nums);
		levels.add(0);
		List<int[]> startpath = new ArrayList<int[]>();
		startpath.add(nums);
		paths.add(startpath);
		
		
		while (!q.isEmpty()) {
			int[] arr = q.remove();
			int level = levels.remove(); 
			List<int[]> path = paths.remove(); 
			
			if (isSorted(arr)) {
				printPath(path);
				return level;
			}
			
			for (int i = 0; i < arr.length-1; i++) {
				for (int j = i; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						int[] temp = swap(arr, i , j);
						q.add(temp);
						levels.add(level + 1);
						List<int[]> temppath = new ArrayList<int[]>(path); 
						temppath.add(temp);
						paths.add(temppath);
					}
				}			
			}			
			
		}
		
		return 0;
	}
	
	static private int[] swap (int[] arr, int i, int j) {
		int[] temp = arr.clone();
		int t = temp[j];
		temp[j] = temp[i];
		temp[i] = t;
		
		return temp;
	}
	
	static private void printPath(List<int[]> path) {
		for (int[] p : path) {
			for (int i = 0; i < p.length; i++) {
				System.out.print(p[i]);
			}
			
			System.out.println();
		}		
	}
	
	
	static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] > arr[i+1])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,3,1,2,9,6,7,0};
		System.out.println(sort(arr));
	}

}



 