package recursion;

/*
 * We'll say that a "pair" in a string is two instances of a char separated by a char. 
 * So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. 
 * Recursively compute the number of pairs in the given string.
 */
public class CountPairs {

	public static int recurse (String x) {
		int pairs = 0;
		char char0 = x.charAt(0);
		char char2 = x.charAt(2);

		if (char0 == char2) {
			pairs++;
		}
		
		String newString = x.substring(1);
		
		if (newString.length() > 2) {
			pairs = pairs + recurse(newString);
		}
		
		return pairs;
	}
	
	
	public static void main(String[] args) {
		System.out.println(recurse ("axa"));
		System.out.println(recurse ("axax"));
		System.out.println(recurse ("axbx"));
		System.out.println(recurse ("AxAxA"));
	}

}
