package stack;

import java.util.Stack;

/*
 * Given a string of braces e.g. {[]{(})} determine if the string
 * is balanced i.e. there is a closing brace for every opening brace
 *  
 * ((((((((([[[{}]]])))))))))
 * [[[[]]()]]
 * ((({()}[])))
 * (())[[]])
 *
 */

public class BracesCloser {

	private static boolean isOpeningBrace (char c) {
        if (c == '(' || c == '{' || c == '[')
            return true;
        else 
            return false;
    }
    
    private static boolean isValidPair (char closing, char opening) {
        if (opening == '(' && closing == ')')
            return true;
        else if (opening == '{' && closing == '}')
            return true;
        else if (opening == '[' && closing == ']')
            return true;
        else
            return false;
    }
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        char[] parens = s.toCharArray();
        
        for (int i = 0; i < parens.length; i++) {
            char paren = parens[i];
            
            if (isOpeningBrace(paren)) {
                stack.push(paren);   
            } else {
                // closing brace
                char popped;
                
                try {
                    popped = stack.pop();
                } catch (java.util.EmptyStackException e) {
                    return false;    
                }
                
                if (!isValidPair(paren, popped)) {
                    return false;
                } 
                
            }
        }

        if (!stack.empty())
            return false;
        
        return true;
    }

	public static void main(String[] args) {
		System.out.println (isValid("((((((((([[[{}]]])))))))))"));
		System.out.println (isValid("("));
		System.out.println (isValid("]"));
		System.out.println (isValid("[]{}()"));
	}
}