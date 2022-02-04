package recursion;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string of characters.
 * 
 *  input: abc
 *  output: abc, acb, bac, bca, cab, cba
 */
public class PermuteString {
	public static ArrayList<String> result = new ArrayList<String>();  //if you don't want dupes, use a Set instead

	public static void recurse (String s, String permutation) {
		
		if (s.length() == 0) {
			result.add(permutation);
			return;
		}
		
		for (int i=0; i < s.length(); i++) {
			// remove char i and find permutations of remaining chars
			char c = s.charAt(i);						
			String newString = s.substring(0,i) + s.substring(i+1); //remove that character from the string
			
			String newPermutation = permutation + c;
			recurse(newString, newPermutation);
		}
		
	}
	
	
	public static void main(String[] args) {
		recurse("abc", "");
		System.out.println(result);
	}

}
