package strings;

/*
 * Compares the equality operator and the equals() method
 */
public class StringEquality {

	public static void main(String[] args) {
		/**
		 * The only right way to compare string values is using equals()
		 */
		
		String str = "blue";

		if (str.equals("blue")) {
			System.out.println("one");
		}

		if (str == "blue") {
			System.out.println("two"); 
		}

		if (str.equals(new String("blue"))) {
			System.out.println("three"); 
		}

		if (str == new String("blue")) {
			System.out.println("four"); 
		}
		
		String first = "first";
		String second  =  new String("first");
		"first".concat("second");
		System.out.println(first.equals(second));
		System.out.println(first == second);
		System.out.println(first.equals("firstsecond"));
		System.out.println(second == "first");
		
		String strl = "My String";
		String str2 = new String  ("My String");
		
		boolean val = strl.hashCode() == str2.hashCode();
		System.out.println ("Val : " + val);

	}
	
}
