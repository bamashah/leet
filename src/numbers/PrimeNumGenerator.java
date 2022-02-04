package numbers;


/**
 * Given a number n, print all prime numbers less than n
 * 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43 ...
 */
public class PrimeNumGenerator {

	public static boolean isPrime (int n) {
		if (n < 2) return false;
		else if (n == 2) return true;
		
		for (int i = 2; i < n; i++) {
			if ((n%i) == 0) return false;
			
		}
		
		return true;
	}
	
	
	public static void generate (int n) {
		
		for (int i = 0; i < n ; i++) {
			if (isPrime(i)) 
				System.out.print(i + " ");
		}
		
	}
	
	public static void main(String[] args) {
		generate (40);
	}

}
