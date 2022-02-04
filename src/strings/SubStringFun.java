package strings;


/*
 * Given a string and a non-empty substring sub, compute recursively the length of largest substring 
 * which starts and ends with sub and return its length.
*/
public class SubStringFun {
	
	public static int strDistIterative(String str, String sub) {
		int begin = 0;
		int end = 0;
		int subLength = sub.length();
			
		if (str.indexOf(sub) == -1) return 0;

		for (int i=0; i<= (str.length() - subLength); i++) {
			if (str.substring(i,i+subLength).equals(sub)) {
				begin = i;
				break;
			}
		}
			
		for (int i=str.length() - subLength; i>=0; i--) {
			if (str.substring(i,i+subLength).equals(sub)) {
				end = i;
				break;
			}
		}
					
		return ((end - begin) + subLength);
	}
	
	
	public static int strDistRecusive(String str, String sub) {
		return recurse (str, sub, 0, -1, -1);
	}

	public static int recurse (String str, String sub, int i, int start, int end) {
		if (str.length() < sub.length()) {
			if (start == -1)
				return 0;
			else
				return end - start + sub.length();
		}
	  
		if (str.substring(0, sub.length()).equals(sub)) {
			if (start == -1) {
				start = i;
				end = i;
			} else 
				end = i;
		}
	  
		return recurse (str.substring(1), sub, i+1, start, end);
	}

	public static void main(String[] args) {
		System.out.println((strDistIterative("catcowcat", "cat")));
		System.out.println((strDistIterative("catcowcat", "cow")));
		
		System.out.println((strDistRecusive("catcowcat", "cat")));
		System.out.println((strDistRecusive("catcowcat", "cow")));
	}
	
}
