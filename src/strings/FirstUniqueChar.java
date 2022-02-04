package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueChar {

	// O(n^2) time complexity. 
    public static int doIt(String s) {
        int index = -1;
        
        for (int i = 0; i < s.length(); i++) {
            boolean founddupe = false;
            
            for (int j = 0; j < s.length(); j++) {
                if (i == j) continue;
                
                if (s.charAt(i) == s.charAt(j)) {
                    founddupe = true;
                    break;
                }
            }
            
            if (!founddupe) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
	// O(n) time complexity. But uses O(n) space
    public static int doItEff(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        //O(n)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count+1);
            } else 
                map.put(c, 1);
        }
        
        //O(n)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return i;        
        }        
        
        return -1;
    }    
    
	public static void main(String[] args) {
		System.out.println (doIt("eeooz"));
		System.out.println (doIt("abcdefgg"));
		System.out.println (doIt("oo"));
		System.out.println (doIt("p"));
	}    
    
}
