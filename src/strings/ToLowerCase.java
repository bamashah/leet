package strings;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {

	public static String convert(String str) {
        String ret = "";
        char[] arr = str.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            
            int diff = ch - 'A';
            if ((diff >= 0) && (diff < 26)) {
                ret = ret + (char)('a' + diff);
            } else
                ret = ret + ch;
            
        }
        
        return ret;
    }
    
	public static void main(String[] args) {
		System.out.println(convert("hElLo!"));
	}

}
