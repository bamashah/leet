package recursion;

/* 
 * Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, 
 * except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. 
 * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
 * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
 */
public class Count8 {

	public static int count8(int n) {
		if (n == 0) return 0;
		  
		int digit = n%10;
		int leftdigit = (n/10)%10;
		  
		if (digit == 8) {
		    if (leftdigit == 8) {
		     return 2 + count8(n/10);
		    } else {
		     return 1 + count8(n/10);
		    }
		} else 
		    return 0 + count8(n/10);
		  
	}
	
	
	public static void main(String[] args) {
		System.out.println(count8 (8818));
		System.out.println(count8 (8));
		System.out.println(count8 (8008));
		System.out.println(count8 (8888));		
	}

}
