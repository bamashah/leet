package bit;

/* 
 * Write a recursive function to multiply two positive integers without using the * operator.
 * You can use addition, subtraction, and bit shifting, but you should minimze the number of those operations. 
 * 
 * If m Even:
 * 5 x 8
 * is (5 x 4) x 2
 * is (5 x 2) x 2 x 2
 * is (5 x 1) x 2 x 2 x 2
 * 
 * If m is Odd:
 * 5 x 7
 * is ((5 x 3) x 2) + 5
 * is (((5 x 1) x 2) + 5) x 2) + 5
 */
public class Multiply {

	public static int recurse (int n, int m) {
		int result = 1;
		
		if (m == 1)
			return n;
		
		if ((m & 1) == 1) {
			// m is odd
			result = (recurse(n, m >> 1) << 1) + n;
		} else {
			// m is even
			result = (recurse(n, m >> 1) << 1);			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println (recurse(6, 4));
	}

}
