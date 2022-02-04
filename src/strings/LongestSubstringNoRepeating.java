package strings;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Given "dvdf", the answer is "vdf", with the length of 3. 
 */
public class LongestSubstringNoRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String sub = new String();
        
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (sub.indexOf(c) == -1) {
                sub = sub + c;
                max = Math.max(max, sub.length());
                i++;
            } else {
            	// restart after the first repeating character.
            	// so in the case of dvdf, start looking at v                
                i = s.lastIndexOf(c,i-1)+1;
                sub = "";
            }
            
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		String a = "abcabcbb";
		String b = "bbbbb";
		String c = "pwwkew";
		String d = "dvdf";
		
		
		System.out.println (a + " - " + lengthOfLongestSubstring(a));
		System.out.println (b + " - " + lengthOfLongestSubstring(b));
		System.out.println (c + " - " + lengthOfLongestSubstring(c));
		System.out.println (d + " - " + lengthOfLongestSubstring(d));
	}

}
