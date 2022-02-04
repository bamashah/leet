package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 *
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * 
 * These lists A and B will not contain duplicates. 
 */
public class AnagramMappingsNoDupes {

	//O(n square) complexity
    public static int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    result[i] = j;
                    break;
                }    
            }
        }
        
        return result;	
    }
	
    //O(n) complexity (will only work if no duplicates because put call will replace previous value)
    public static int[] anagramMappingsEff(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        
        //O(n)
        for (int j = 0; j < B.length; j++) 
            mymap.put(B[j], j);
                
        
        //O(n)
        for (int i = 0; i < A.length; i++) {
            result[i] = mymap.get(A[i]);  // hashtable lookup is O(1)
        }
        
        return result;
    }	
	
	public static void main(String[] args) {
		int[] arr1 = {8, 28, 46, 12, 50};
		int[] arr2 = {50, 8, 12, 46, 28};

		//int[] result = anagramMappings (arr1, arr2);
		int[] result = anagramMappingsEff (arr1, arr2);
		
		for (int i = 0; i<result.length; i++)
			System.out.print (result[i] + " ");
	}

}
