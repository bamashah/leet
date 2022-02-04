package bit;

public class OddOrEven {

	public static int isOdd (int n) {
		// How to check if number is odd or even
		// if even, anding with 1 will result in 0
		// if odd, anding with 1 will result in 1
		
		return n & 1;
	}
	
	public static void main(String[] args) {
		int num1 = 33;
		int num2 = 34;		
		
        System.out.println ("Is " + num1 + " odd?   " + isOdd(num1));
        System.out.println ("Is " + num2 + " odd?   " + isOdd(num2));
	}

}
