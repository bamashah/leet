package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
 * Return a list of all possible strings we could create.
 * 
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 *
 */
public class LetterCasePermutation {
	static List<String> list = new ArrayList<String>();
	
    public static List<String> letterCasePermutation(String S) {
        recurse (S, "");
        return list;
    }
    
    private static void recurse (String s, String t) {
        if (s.length() == 0) {
            list.add(t);
            return;
        }
        
        char c = s.charAt(0);
        
        if (Character.isLetter(c)) {
            recurse (s.substring(1), t + Character.toLowerCase(c));            
            recurse (s.substring(1), t + Character.toUpperCase(c));
        } else {
            recurse (s.substring(1), t + c);            
        }
        
    }
    
	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2C"));
	}

}
