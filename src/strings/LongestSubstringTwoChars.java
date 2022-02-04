package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Given "eceba", the answer is "ece", which the length is 3.
 * Given "ccaabbb", the answer is "aabbb", with the length of 5.
 */
public class LongestSubstringTwoChars {

	//O(n) solution
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) return s.length();
        
        Set<Character> subCharsSet = new HashSet<Character>();
        int max = 0;
        int i = 0;
        int transitionIndex = 0;  // where the char changes. so we can go back and start looking from there. 
        char prev = s.charAt(0);
        String sub = new String();
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if ((subCharsSet.contains(c)) || (subCharsSet.size() < 2)) {
            	subCharsSet.add(c); // add anyway even if it exists
                sub = sub + c;
                max = Math.max(max, sub.length());
                if (c != prev) {    
                	transitionIndex = i;
                    prev = c;
                }
                i++;
            } else {
                sub = "";
                i = transitionIndex;
                prev=s.charAt(i-1);
                subCharsSet = new HashSet<Character>();                
            }       
        }
           
        return max;
    }

    
	//easier O(n^2) solution
    public static int lengthOf(String s) {
    	if (s.length() < 3) return s.length();    	
    	int max = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		Set<Character> subCharsSet = new HashSet<Character>();
    		String sub = "" + s.charAt(i);
    		subCharsSet.add(s.charAt(i));
    		
    		for (int j = i+1; j < s.length(); j++) {
    			char c = s.charAt(j);
    			if ((subCharsSet.contains(c)) || (subCharsSet.size() < 2)) {
    	    		subCharsSet.add(c);
    				sub = sub + c;
    				max = Math.max(max, sub.length());
    			} else
    				break;
    		}
    	}
    
        return max;
    }
    
    
	public static void main(String[] args) {
		String a = "eceba";
		String b = "ccaabbb";
		String c = "pwwkew";
		String d = "ddddd";
		
		System.out.println (a + " - " + lengthOfLongestSubstringTwoDistinct(a));
		System.out.println (b + " - " + lengthOfLongestSubstringTwoDistinct(b));
		System.out.println (c + " - " + lengthOfLongestSubstringTwoDistinct(c));
		System.out.println (d + " - " + lengthOfLongestSubstringTwoDistinct(d));
		System.out.println (a + " - " + lengthOf(a));
		System.out.println (b + " - " + lengthOf(b));
		System.out.println (c + " - " + lengthOf(c));
		System.out.println (d + " - " + lengthOf(d));
	}

}
