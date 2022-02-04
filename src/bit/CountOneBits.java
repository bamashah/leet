package bit;

/*
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 */

public class CountOneBits {
	
   public static int countSetBits(long num) {
        int count = 0;
        
        while (num > 0) {
            long modulo = num%2; 
            
            if (modulo == 1) count++;
            
            num = num/2;
        }
        
        return count;
    }
	   
	public static void main(String[] args) {
		System.out.println (countSetBits(78)); // 1001110
		System.out.println (countSetBits(16)); // 10000
		System.out.println (countSetBits(101)); // 1100101
		System.out.println (countSetBits(3)); // 11
	}

}
