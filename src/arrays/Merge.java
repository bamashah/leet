package arrays;

/*
 * Given two sorted arrays, merge the two arrays into one
 */

public class Merge {

	public static int[] union (int[]arr1, int[] arr2) {
		
		int m = arr1.length;
		int n = arr2.length;
        int[] mergedarr = new int[m+n];
        
        int i=0, j=0, k=0;
						
		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				mergedarr[k] = arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				mergedarr[k] = arr2[j];
				j++;
			} else if (arr1[i] == arr2[j]) {
				mergedarr[k++] = arr1[i];
				mergedarr[k] = arr2[j];
				i++;
				j++;
			}
			
			k = k + 1;	
		}
				
		for (int p = j; p < n; p++) {
			mergedarr[k++] = arr2[p];
		}

		for (int p = i; p < m; p++) {
			mergedarr[k++] = arr1[p];
		}

		return mergedarr;
	}
	
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,4,7};
		int[] result = union (arr1, arr2);
		
		for (int i=0; i < result.length; i++)
			System.out.print (result[i] + " ");
	}

}
