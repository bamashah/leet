package recursion;

/**
 * We are given two strings: string S of length n, and string T of length m. 
 * Our goal is to produce their longest common subsequence: 
 * the longest sequence of characters that appear left-to-right 
 * (but not necessarily in a contiguous block) in both strings.
 * 
 * This type of problem comes up all the time in genomics: 
 * given two DNA fragments, the LCS gives information about 
 * what they have in common and the best way to line them up.
 * 
 * Input(S): ASFDFDV123
 * Input(T): ADFDFDSVDB123
 * Output: 9
 *
 */
public class LongestCommonSubsequence {

    public static int recurse(String S, String T, int i, int j) {
        if ((i == S.length()) || (j == T.length()))  return 0;

        if (S.charAt(i) == T.charAt(j)) {
        	return 1 + recurse(S, T, i + 1, j + 1);
        } else {
	        return Math.max(recurse(S, T, i, j + 1), recurse(S, T, i + 1, j));
        }
    }

    public static void main(String[] args) {
        String S = "ABAZDC";
        String T = "BACBAD";
        System.out.println(recurse(S, T, 0, 0));
    }
}
