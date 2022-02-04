package numbers;

/**
 * 1. Given a positive integer, return its corresponding column title as it appears in an Excel sheet.
 * 
 *    1 -> A
 *    2 -> B
 *    3 -> C
 *    ...
 *    26 -> Z
 *    27 -> AA
 *    28 -> AB
 *    
 *    
 * 2. Given a column title as appears in an Excel sheet, return its corresponding column number.   
 * 
 *    A -> 1
 *    B -> 2
 *    C -> 3
 *    ...
 *    Z -> 26
 *    AA -> 27
 *    AB -> 28 
 *
 */
public class ExcelColumns {

    public static String numberToTitle(int n) {
        String s = new String();
        char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        while (n != 0) {
            n = n-1;
            int val = n%26;
            s = alpha[val] + s;
            n = n/26;
        }
        
        return s;
    }
    
    public static int titleToNumber(String s) {
        int sum = 0;
        int place = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            int val = ch - 'A' + 1;
            
            sum = sum + (place*val);
            place = place * 26;
            
        }
        
        return sum;
    }    
	
	public static void main(String[] args) {

		System.out.println (numberToTitle(28));
		System.out.println (titleToNumber("AB"));
	}
	
}
