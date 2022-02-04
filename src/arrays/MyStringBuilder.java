package arrays;

/**
 * My own StringBuilder implementation.
 * A StringBuilder class stores the string as a character array.
 */
public class MyStringBuilder {
	char[] arr;
	int maxIndex;
	
	public MyStringBuilder(int size) {
		arr = new char[size];
		maxIndex = 0;
	}
	
	public MyStringBuilder() {
		this(10);
	}
	
	public MyStringBuilder(String init) {
		arr = init.toCharArray();
		maxIndex = init.length();
	}
	
	private void expand(int newsize) {
		int oldsize = arr.length;
		char[] newArr = new char[newsize];

		for (int i=0;i<oldsize;i++) {
			newArr[i] = arr[i];
		}
		
		arr = newArr;
	}
	
	public void insert (int pos, String val) {
		
		// first copy the chars that need to be moved to a temp array
		int offset = maxIndex - pos;
		char[] temp = new char[offset];
		for (int i = pos, j=0; i < arr.length; i++, j++) {
			temp [j] = arr[i];
		}

		if ((maxIndex + val.length()) > arr.length) {
			expand(maxIndex + val.length());
		}
				
		char[] valArray = val.toCharArray();
		for (int i=0,j=pos ; i<valArray.length ; i++,j++) {
			arr[j] = valArray[i];
		}
		
		for (int i=0,j=pos+val.length() ; i<temp.length ; i++,j++) {
			arr[j] = temp[i];
		}
		
		
		maxIndex = maxIndex + val.length();
	}
	
	public void append (String val) {
		// append(x) has the same effect as insert(maxIndex, x)
		insert (maxIndex, val);
	}
	
	public void print() {
		for (int i=0;i<arr.length;i++) {
			if (arr[i] == 0) {
				System.out.print ("_ ");
			} else {
				System.out.print (arr[i] + " ");
			}
		}
		
		System.out.println();
	}
	
	public String toString() {
		return new String (arr);
	}
	
	public static void main(String[] args) {
		MyStringBuilder mahString = new MyStringBuilder("foodie");
		mahString.insert(2, "bar");
		mahString.append("baz");
		mahString.insert(0, "eep");

		System.out.println (mahString.toString());
	}

}
