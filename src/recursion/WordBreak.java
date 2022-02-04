package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] Output: false
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        
        String temp = new String();
        boolean retval = false;
        
        for (int i = 0; i < s.length(); i++) {
            temp = temp + s.charAt(i);
            
            if (wordDict.contains(temp)) {
                String remainingString = s.substring(i+1);
                boolean val = wordBreak (remainingString, wordDict);
                retval = retval || val;
            }     
        }
        
        return retval;
    }
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("and");
		list.add("pen");
		
		System.out.println (wordBreak ("applepenapple", list));
	}

}
