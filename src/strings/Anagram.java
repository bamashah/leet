package strings;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 */
public class Anagram {

    public static boolean isAnagram(String s, String t) {
        int[] counter = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        for (int i = 0; i < sArr.length; i++) {
            char ch = sArr[i];
            counter[ch-'a'] = counter[ch-'a'] + 1;
        }

        for (int j = 0; j < tArr.length; j++) {
            char ch = tArr[j];
            counter[ch-'a'] = counter[ch-'a'] - 1;
        }

        for (int k = 0; k < counter.length; k++) {
            if (counter[k] != 0)
                return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		System.out.println (isAnagram("anagram","nagaram"));
		System.out.println (isAnagram("cat","rat"));
	}

}
