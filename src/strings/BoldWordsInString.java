package strings;

/**
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.
 * The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
 * 
 * For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". 
 * Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 * 
 */
public class BoldWordsInString {

    public static String boldWords(String[] words, String S) {
        boolean[] marked = new boolean[S.length()];
        
        for (int i = 0; i < words.length; i++) {
            mark(words[i], S, marked);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            if (marked[i] && (i == 0 || !marked[i-1]))   {
                sb.append("<b>");
            }
            
            sb.append(S.charAt(i));
            
            if (marked[i] && ((i == S.length()-1) || !marked[i+1]))   {
                sb.append("</b>");
            }
        }
        
        return sb.toString();
    }
    
    public static void mark (String word, String S, boolean[] marked) {
        for (int i = 0; i <= S.length()-word.length(); i++) {
            if (S.substring(i, i+word.length()).equals(word)) {
                for (int j = i; j < i+word.length(); j++) {
                	marked[j] = true;
                }
            }
        }
    }	
	
	
	public static void main(String[] args) {
		String[] words = {"ab", "bc"};
		System.out.println(boldWords(words, "aabcd"));

	}

}
