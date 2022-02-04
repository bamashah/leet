package strings;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue", return "blue is sky the".
 *
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * 
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * 
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string
 */
public class ReverseWords {

    public static String reverse (String s) {
        String[] words = s.trim().split("\\s+");
        
        String retVal = new String();
        
        for (int i = words.length-1; i >= 0; i--) {
            retVal = retVal + words[i] + " ";
        }
        
        return retVal.trim();
    }
    
	public static void main(String[] args) {
		System.out.println(reverse(" the  sky is blue"));

	}

}
