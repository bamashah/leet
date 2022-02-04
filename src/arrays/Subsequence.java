package arrays;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some 
 * (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * s = "abc", t = "ahbgdc" return true
 * s = "axc", t = "ahbgdc" return false
 *
 */
public class Subsequence {

    public static boolean isSubsequence(String sub, String string) {
        char[] subArr = sub.toCharArray();
        char[] strArr = string.toCharArray();
        
        if (subArr.length == 0) return true;
        
        int i = 0, j = 0;
        
        while ((j < strArr.length) && (i < subArr.length)) {
            if (strArr[j] == subArr[i]) i++;
            
            j++;
        }
        
        if (i == sub.length())
            return true;
        else 
            return false;
        
    }
    
	public static void main(String[] args) {
		System.out.println(isSubsequence("axc", "ahbgdc"));
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("abc", "ahcbcd"));
	}

}
