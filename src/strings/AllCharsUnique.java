package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if all the characters in a string are unique. 
 * What if you cannot use additional data structures?
 */
public class AllCharsUnique {

	//O(n) complexity, O(n) space
	public static boolean doesStringHaveAllUniqueChars (String myString) {
		Set<Character> mySet = new HashSet<Character>();
		
		for (int i=0; i < myString.length(); i++) {
			char c = myString.charAt(i);
			if (!mySet.add(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	//O(n^2) complexity, O(1) space
	public static boolean doesStringHaveAllUniqueCharsWithoutAdditionalDataStructures (String myString) {
		for (int i=0; i < myString.length(); i++) {
			char c1 = myString.charAt(i);
			
			for (int j=i+1; j < myString.length(); j++) {
				char c2 = myString.charAt(j);
				
				if (c1 == c2) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println (doesStringHaveAllUniqueChars("heloO"));
		System.out.println (doesStringHaveAllUniqueChars("abcdefgg"));
		System.out.println (doesStringHaveAllUniqueChars("oo"));
		System.out.println (doesStringHaveAllUniqueChars("p"));
		System.out.println ("-----");
		System.out.println (doesStringHaveAllUniqueCharsWithoutAdditionalDataStructures("heloO"));
		System.out.println (doesStringHaveAllUniqueCharsWithoutAdditionalDataStructures("abcdefgg"));
		System.out.println (doesStringHaveAllUniqueCharsWithoutAdditionalDataStructures("oo"));
		System.out.println (doesStringHaveAllUniqueCharsWithoutAdditionalDataStructures("p"));

	}

}
