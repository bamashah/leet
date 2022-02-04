package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. 
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * Input: [1,2,3,4,5,6,9], k=3, x=7
 * Output: [5,6,9]
 */
public class ClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Pair> diffList = new ArrayList<Pair>();
        
        for (int num : arr) {
            Pair p = new Pair (num, Math.abs(x-num));
            diffList.add(p);
        }
        
        Collections.sort(diffList);
        
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        
        for (int i = 0; i < k; i++) {
            returnList.add(diffList.get(i).num);
        }
        
        Collections.sort(returnList);
        return returnList;
    }
    
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,9};
		System.out.println (findClosestElements (arr, 3, 7));		
	}    
}

class Pair implements Comparable<Pair> {
	int num;
	int diff;
	
	public Pair (int num, int diff) {
		this.num = num;
		this.diff = diff;
	}

	@Override
	public int compareTo(Pair p) {
		if (p.diff == this.diff)
			return 0;
		else if (this.diff > p.diff)
			return 1; // sort ascending order
		else
			return -1;
	}
		
}
