package recursion;

import java.util.Date;

/** 
 * Given a number n, write a method which will return the nth fibonacci number *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 */
public class Fibo {

	// This is using plain recursion. The efficiency here is O(2^n). So not very efficient. 
	// You can see that it is calculating the fib of lower numbers repeatedly. 
	public static int getNthRecurseive (int n) {
		if ((n == 0) || (n == 1)) {
			return n;
		} else {
			return getNthRecurseive(n-1) + getNthRecurseive(n-2);
		}
	}


	// This is using recursion but it is also using cache
	public static int getNthRecurseiveCached (int n) {
		return getNthRecurseiveCached(n, new int[n+1]);
	}
	
	private static int getNthRecurseiveCached (int n, int[] cache) {
		if ((n == 0) || (n == 1)) return n;
		
		if (cache[n] == 0) {		
			cache[n] = getNthRecurseiveCached(n-1, cache) + getNthRecurseiveCached(n-2, cache);
		}
		
		return cache[n];
		
	}
	
	// This is using iteration
	public static int getNthIterative (int n) {
		int fib = 0;
		int last = 1;
		int beforeLast = 0;
		
		if (n == 1) {
			fib = 1;
		}
		
		for (int i=2; i <= n; i++) {
			fib = last + beforeLast;
			beforeLast = last;
			last = fib; 
		}
		
		return fib;
	}
	
	public static void main(String[] args) {
		
		System.out.println (new Date());
		for (int i=0; i < 5; i++) {
			System.out.println (i + " : " + getNthIterative(i));
		}
		System.out.println (new Date());
		System.out.println();
		for (int i=0; i < 5; i++) {
			System.out.println (i + " : " + getNthRecurseive(i));
		}
		System.out.println (new Date());
		System.out.println();
		for (int i=0; i < 5; i++) {
			System.out.println (i + " : " + getNthRecurseiveCached(i));
		}
		System.out.println (new Date());

	}

}
