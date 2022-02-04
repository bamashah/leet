package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings write a method to decide if one is a permutation
 * of the other
 */
public class Permutation {

	public static boolean isPermutation (String str1, String str2) {
		Map<Character,Integer> myMap = new HashMap<Character,Integer>();
		for (int i=0;i<str1.length();i++) {
			char c = str1.charAt(i);
			int count = 0;
			if (myMap.containsKey(c)) {
				count = myMap.get(c); 
			}
			
			count++;
			myMap.put(c, count);			
		}
		
		for (int i=0;i<str2.length();i++) {
			char c = str2.charAt(i);
			int count = 0;
			if (myMap.containsKey(c)) {
				count = myMap.get(c); 
			}
			
			count--;
			myMap.put(c, count);			
		}

		for (char c : myMap.keySet()) {
			int count = myMap.get(c);
			if (count != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println (isPermutation("dream","madre"));
		System.out.println (isPermutation("dreem","madra"));		
		System.out.println (isPermutation("dsdf","dsdd"));
	}

}
