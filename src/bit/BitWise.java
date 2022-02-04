package bit;

public class BitWise {

	public static boolean isOdd (int n) {
		// How to check if number is odd or even
		// if even, anding with 1 will result in 0
		// if odd, anding with 1 will result in 1
		
		return (n & 1) == 1;
	}
	
	public static int halve (int n) {
		// Right-shift by 1 will return half for even numbers
		// Right-shift by 1 will return half rounded down for odd number
		return n >> 1;
	}
	
	public static int doubleIt (int n) {
		// Left-shift by 1 will double the number
		return n << 1;
	}
	
	public static void main(String[] args) {
		int num1 = 33;
		int num2 = 34;
        System.out.println ("Is " + num1 + " odd?   " + isOdd(num1));
        System.out.println ("Is " + num2 + " odd?   " + isOdd(num2));

        System.out.println ("Half of " + num1 + " is   " + halve(num1));
        System.out.println ("Half of " + num2 + " is   " + halve(num2));

        System.out.println ("Double of " + num1 + " is   " + doubleIt(num1));
        System.out.println ("Double of " + num2 + " is   " + doubleIt(num2));        
	}

}
