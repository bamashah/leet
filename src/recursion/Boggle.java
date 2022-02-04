package recursion;

/**
 * count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ 
 * with at-most one ‘b’ and two ‘c’s allowed.
 *
 */
public class Boggle {

	private static int countBs (String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'b') 
				count++;
		}
		
		return count;
	}
	
	private static int countCs (String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'c') 
				count++;
		}
		
		return count;
	}
	
	public static int recurse (int n, String s) {
		if (s.length() == n) {
			System.out.println(s);
			return 1;
		}
		
		return recurse (n, s + "a") +  (countBs(s)<1?recurse (n, s + "b"):0) + (countCs(s)<2?recurse (n, s + "c"):0);	
	}
	
	
	public static void main(String[] args) {
		System.out.println(recurse(1, ""));
	}

}
