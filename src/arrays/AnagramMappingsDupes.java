package arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 *
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * 
 * These lists A and B may contain duplicates. 
 */
public class AnagramMappingsDupes {


    //O(n) complexity 
    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] result = new int[A.length];
        
        for(int i = 0; i < B.length; i++) {
            if(map.containsKey(B[i])) {
                map.get(B[i]).add(i);
            } else {
                LinkedList<Integer> indices = new LinkedList<Integer>();
                indices.add(i);
                map.put(B[i], indices);
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            int indice = map.get(A[i]).remove(0);
            result[i] = indice;
        }
        
        return result;
    }    
	
	public static void main(String[] args) {
		int[] arr1 = {12, 28, 46, 12, 50};
		int[] arr2 = {50, 12, 12, 46, 28};

		int[] result = anagramMappings (arr1, arr2);
		
		for (int i = 0; i<result.length; i++)
			System.out.print (result[i] + " ");
	}

}
