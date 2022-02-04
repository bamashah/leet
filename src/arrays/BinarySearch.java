package arrays;

/**
 * Find a number in a sorted array using binary search
 *
 */
public class BinarySearch {

	public static boolean search (int[] list, int n) {
		boolean found = false;
		
		int low = 0;
		int high = list.length - 1; 
		
		while (low <= high) {
			int mid = (low + high)/2;//there is a problem with this. for bigger numbers it causes overflow issues. see https://research.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
            //int mid = low + (high - low) / 2;
			
			if (n == list[mid]) {
				found = true;
				break;
			} else if (n < list[mid]) {
				high = mid - 1;
			} else if (n > list[mid]) {
				low = mid + 1;
			}
		}
		
		return found;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,10,12,15,16};
		System.out.println(search(arr, 8));
	}

}
