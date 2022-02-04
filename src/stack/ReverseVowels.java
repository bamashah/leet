package stack;

import java.util.Stack;


/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Given s = "hello", return "holle".
 * Given s = "leetcode", return "leotcede".
 *
 */
public class ReverseVowels {

    private static boolean isVowel(char ch) {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        
        for (char vowel : vowels) {
            if (ch == vowel) return true;
        }
        
        return false;
    }
    
    
    public static String reverseVowels(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        char[] ch = s.toCharArray();
        
        for (char c : ch) {
            if (isVowel(c)) stack.push(c);
        }
        
        for (int i=0;i<s.length();i++) {
            if (isVowel(ch[i]))
                ch[i] = stack.pop();
        }
        
        String ret = new String(ch);
        return ret;
    }
    
	public static void main(String[] args) {
		System.out.println(reverseVowels("leetcode"));  //leotcede

	}

}
