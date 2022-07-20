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
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                stack.push(c);

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;
                char popped = stack.pop();

                if (!isValidPair(c, popped))
                    return false;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }

	public static void main(String[] args) {
		System.out.println (isValid("((((((((([[[{}]]])))))))))"));
		System.out.println (isValid("("));
		System.out.println (isValid("]"));
		System.out.println (isValid("[]{}()"));
	}
}