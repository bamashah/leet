package recursion;

/**
 * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
 * 
 * countX("xxhixx") - 4
 * countX("xhixhix") - 3
 * countX("hi") - 0
 */
public class CountX {

	public static int countX(String str) {
		  int stringLength = str.length(); 
		  
		  if (stringLength == 0) return 0;
		  
		  char c = str.charAt(0);
		  
		  int retval = 0;
		  if (c == 'x') 
		    retval = 1;

		  if (stringLength > 1) 
		    return retval + countX(str.substring(1, stringLength));
		  else 
		    return retval;
		  
	}
	
	public static void main(String[] args) {
		System.out.println(countX ("xxhixx"));
		System.out.println(countX ("xhixhix"));
		System.out.println(countX ("jj"));
		System.out.println(countX (""));
	}

}
