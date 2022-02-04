package recursion;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some 
 * (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * S = "babgbag", T = "bag"
 * 
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * 
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 * 
 * Return 5.
 *
 * Proper solution to this problem involves DP but I don't know how to do that.
 */
public class Subsequences {
    public static int numDistinct(String s, String t) {
        return recurse(s,t,"");
    }
    
    public static int recurse (String s, String t, String temp) {
        if (temp.equals(t)) 
            return 1;
        else if (s.length() == 0) 
        	return 0;
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String newtemp = new String(temp);
            newtemp = newtemp + s.charAt(i);
            String newString = s.substring (i+1);
            
            result = result + recurse (newString, t, newtemp);
        }
        
        return result;
    }
    
    
	public static void main(String[] args) {
		System.out.println(numDistinct ("babgbag","bag"));
		System.out.println(numDistinct ("ABCDE","ACE"));
	}

}
