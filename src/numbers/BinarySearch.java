package numbers;

/**
 * Use binary search to check if a number m exists between 1 and n. 
 *
 */
public class BinarySearch {
	
    public static int find (int n, int m) {
        int low = 1, high = n;
        int retval = 0;
        
        while(low <= high) {
        	int mid = (low + high) / 2;  //there is a problem with this. for bigger numbers it causes overflow issues. see https://research.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
            //int mid = low + (high - low) / 2;
            
            if(mid == m) {
            	retval = mid;
            	break;
            } else if(m > mid) {
            	low = mid + 1;
            } else if (m < mid) {
            	high = mid - 1;
            }
        }
        
        return retval;
    }	
	
	
	public static void main(String[] args) {
		System.out.println(find(10, 7));
	}

}
