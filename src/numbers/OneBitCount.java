package numbers;

/*
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 */

public class OneBitCount {
   public static int numSetBits(long num) {
        int count = 0;
        
        while (num > 0) {
            long modulo = num%2; 
            
            if (modulo == 1) count++;
            
            num = num/2;
        }
        
        return count;
    }
	   
	public static void main(String[] args) {
		System.out.println (numSetBits(78)); // 1001110
		System.out.println (numSetBits(16)); // 10000
		System.out.println (numSetBits(101)); // 1100101
		System.out.println (numSetBits(3)); // 11
	}

}
