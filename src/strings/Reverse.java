package strings;

/**
 * Reverse a string
 *
 */
public class Reverse {

	public static String reverse1 (String s) {
		StringBuilder newString = new StringBuilder();
		
		for (int i=s.length()-1; i >=0; i--) {
			newString.append(s.charAt(i));
		}
		
		return newString.toString();
	}

	
	public static String reverse2 (String s) {
        char[] chars = s.toCharArray();
        
        int n = chars.length;
        int i = 0, j = n-1;  // use two pointers
        
        while (i <= j) {
        	char temp = chars[j];
        	chars[j] = chars[i];
        	chars[i] = temp;
        	
        	i++;
        	j--;
        }        
        
        String newString = new String (chars);
        return newString;
	}
	
	public static void main(String[] args) {
		System.out.println (reverse1("Madam, I'm Adam"));

	}

}
