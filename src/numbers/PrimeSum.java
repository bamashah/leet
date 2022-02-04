package numbers;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * NOTE A solution will always exist. read Goldbach’s conjecture
 */
public class PrimeSum {
	
	public static List<Integer> primeSum(int n) {
		List<Integer> result = null;
		
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				if (isPrime(n-i)) {
					result = new ArrayList<Integer>();
					result.add(i);
					result.add(n-i);
					break;
				}
			}
		}
		
		return result;
	}
	
	public static boolean isPrime(int n) {
		if (n == 0 || n ==1) 
			return false;
				
		for (int i=2; i<=n/2; i++) {
			if (n%i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int n = 78;
		
        System.out.println(primeSum(n));
        
        
	}

}
