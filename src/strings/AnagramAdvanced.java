package strings;

/**
 * Given a word and a pattern, return the count of the occurrences of anagrams of the pattern in the text
 *
 */
public class AnagramAdvanced {
	
	static int getHash(String str) {
		int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
		int retval = 1;
		char[] arr = str.toCharArray();
		
		for (char c : arr) {
			retval = retval * primes[c - 'a'];
		}
		
		return retval;
	}
	
	static int countNeedles (String text, String pattern) {
		String haystack = text.toLowerCase();
		String needle = pattern.toLowerCase();
		int needleHash = getHash(needle);
		int count=0;
		
		for (int i=0 ; i<=haystack.length()-needle.length() ; i++) {
			String s = haystack.substring(i,i+needle.length());
			
			if (getHash(s) == needleHash)
			// if (Anagram.isAnagram(needle, s)) //probably the better way to do it. 
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println (countNeedles("BACDGABCDAd","ABCD"));
	}

}
