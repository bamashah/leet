package numbers;

/**
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman {
	
    public static String intToRoman(int num) {
        String[] oneslist = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tenslist = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] hundredslist = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};
        String[] thousandslist = {"", "M", "MM", "MMM"};
        
        int ones = num%10;
        int tens = 0;
        int hundreds = 0;
        int thousands = 0;

        if (num/10 != 0) {
        	num = num/10;
        	tens = num%10;
        }

        if (num/10 != 0) {
        	num = num/10;
        	hundreds = num%10;
        }
        
        if (num/10 != 0) {
        	num = num/10;
        	thousands = num%10;
        }        
        	
        String onesRoman = oneslist[ones];
        String tensRoman = tenslist[tens];
        String hundredsRoman = hundredslist[hundreds];
        String thousandsRoman = thousandslist[thousands];
             
        return thousandsRoman + hundredsRoman + tensRoman + onesRoman;
    }
    
	public static void main(String[] args) {
		System.out.println (intToRoman(1762));
	}

}
