package arrays;

/**
 * My own ArrayList implementation
 */
public class MyList {
	String[] arr;
	int maxIndex;
	
	public MyList(int size) {
		arr = new String[size];
		maxIndex = 0;
	}
	
	public MyList() {
		this(10);
	}
	
	
	// doubles the size of the list
	private void expand() {
		int oldsize = arr.length;
		int newsize = oldsize * 2;
		String[] newArr = new String[newsize];

		for (int i=0;i<oldsize;i++) {
			newArr[i] = arr[i];
		}
		
		arr = newArr;
	}
	
	public void add(String val) {
		if (maxIndex == arr.length) {
			expand();
		}
		
		arr[maxIndex] = val;
		maxIndex++;
	}
	
	public void print() {
		for (int i=0;i<arr.length;i++) {
			if (arr[i] == null) {
				System.out.print ("_ ");
			} else {
				System.out.print (arr[i] + " ");
			}
		}
		
		System.out.println();
	}
	
	public void delete (int n) {
		for (int i=n ; i < maxIndex ; i++) {
			arr[i] = arr[i+1];
		}
		
		maxIndex--;
	}
	
	public static void main(String[] args) {
		MyList mahList = new MyList(5);
		mahList.add("a");
		mahList.add("x");
		mahList.add("m");
		mahList.print();
		mahList.add("b");
		mahList.add("y");
		mahList.add("p");
		mahList.print();
		mahList.delete(2);
		mahList.print();
		mahList.add("1");
		mahList.add("2");
		mahList.add("3");
		mahList.add("1");
		mahList.add("2");
		mahList.print();
		mahList.add("3");
		mahList.print();
	}

}
