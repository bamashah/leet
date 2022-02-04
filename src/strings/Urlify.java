package strings;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters, and that 
 * you are given the "true" length of the string. (Note: if implementing in Java, please use a character array 
 * so that you can perform this operation in place.)
 */
public class Urlify {
	public static char[] arr;
	
	public static void doit(int trueSize) {
		int numberOfSpaces = 0;
		for (int i=0;i < trueSize;i++) {
			if (arr[i] == ' ') {
				numberOfSpaces++;
			}
		}
		
		int spacesEncountered = 0;
		for (int i=trueSize-1;i>=0;i--) {
			if (arr[i] == ' ') {
				spacesEncountered++;
				int offset = (numberOfSpaces-spacesEncountered)*2; 
				arr[i + offset] = '%';
				arr[i+1 + offset] = '2';
				arr[i+2 + offset] = '0';
			} else {
				int offset = (numberOfSpaces-spacesEncountered)*2; 
				arr[i + offset] = arr[i];
				arr[i] = '-';
			}
			
			System.out.println(new String(arr));
			
			if (spacesEncountered == numberOfSpaces) {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String myString = "Mr John Smith    ";
		arr = myString.toCharArray();
		doit(13);
	}

	
}

