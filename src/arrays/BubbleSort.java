package arrays;

/** 
 * Sorts a list using Bubblesort technique
 */
public class BubbleSort {

	public static int[] sort (int[] arr) {
		
		for (int j = arr.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				print (arr);
				
				if (arr[i] > arr[i+1]) {
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
				
			}
		}
				
		return arr;	
	}
	
	
	static void print (int[] arr) {
		for (int a : arr) 
			System.out.print(a + " ");
		System.out.println();
	}
	

	public static void main(String[] args) {
		int[] arr = {45,23,11,67,44,1,9,7};		
		int[] result = sort(arr);

		for (int i=0; i < result.length; i++) 
		    System.out.print(result[i] + " ");

	}

}
