package recursion;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * 
 * ()()(), (()()), ()(()), ((())), (())()
 * 
 */
public class ParenPairs {
	static List<String> result = new ArrayList<String>(); 

    public static void recurse (String s, int n) {
        if (s.length() == 2*n) {

            if (isValid(s)) 
                result.add(s);
            
            return;   
        } 
        
        if (getCount('(',s) < n)
            recurse(s + "(", n);
        
        if (getCount(')',s) < n)
            recurse(s + ")", n);  
    }
    
    
    private static int getCount (char c, String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
        }
        
        return count;
    }
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c == '(') 
				stack.push(c);
			else if (c == ')') {
				try {
					if (!(stack.pop() == '(')) {
						return false;
					}
				} catch (EmptyStackException e) {
					return false;
				}
			}
		}
		
	    if (!stack.empty()) {
	    	return false;
	    }
		
		return true;
	}
	
	public static void main(String[] args) {
		int n = 3;
		recurse (new String(), n);
		System.out.println (result);
	}

}
