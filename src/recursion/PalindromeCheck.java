package recursion;

public class PalindromeCheck {

    public static boolean recurse(String s) {

        if (s.length() == 1) 
            return true;
        else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) 
                return true;
            else 
                return false;
        } else {
            if (s.charAt(0) == s.charAt(s.length()-1)) {
                return recurse(s.substring(1,s.length()-1));
            } else
                return false;
        }
        
    }
	
	
	public static boolean iterate (String s) {
		boolean result = true;
		for (int i = 0; i < (s.length()/2); i++) {
			if (s.charAt(i) == s.charAt(s.length()-1-i))
				continue;
			else {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println (iterate("malayalam"));
		System.out.println (recurse("malayalam"));
	}

}
