package bit;

public class HalfOrDouble {

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
		int num1 = 8;
		int num2 = 9;

        System.out.println ("Half of " + num1 + " is   " + halve(num1));
        System.out.println ("Half of " + num2 + " is   " + halve(num2));

        System.out.println ("Double of " + num1 + " is   " + doubleIt(num1));
        System.out.println ("Double of " + num2 + " is   " + doubleIt(num2));        
	}

}
