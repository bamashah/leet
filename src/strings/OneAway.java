package strings;

/*
 * There are three types of edits that can be performed on strings: insert a character, 
 * remove a character, or replace a character. Given two strings, write a function to 
 * check if they are one edit away.
 * 
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 */
public class OneAway {
		
	public static boolean checkDiff (String str1, String str2) {
		if (str1.equals(str2)) return false;
		
		int m = str1.length();
		int n = str2.length();
		
	    if(Math.abs(m-n)>1){
	        return false;
	    }
	    
		int diffs = 0;

	    int i=0; 
	    int j=0; 
	 
	    while(i<m && j<n){
	    	if (str1.charAt(i) == str2.charAt(j)) {
	    		i++; j++;
	    	} else {
	    		diffs++;
	    		if (diffs > 1) return false;
	    		
	    		if (m > n) 
	    			i++;
	    		else if (m < n)
	    			j++;
	    		else {
	    			i++; j++;
	    		}
	    	}
	    	
	    }
		
	    if(i<m || j<n){
	        diffs++;
	    }
	 
	    if(diffs > 1)
	        return false;
	    else 
	    	return true;
	}
	
	public static void main(String[] args) {
		System.out.println (checkDiff ("", ""));
		System.out.println (checkDiff ("pale", "ple"));
		System.out.println (checkDiff ("pale", "pales"));
		System.out.println (checkDiff ("pale", "bale"));
		System.out.println (checkDiff ("pale", "bake"));
		System.out.println (checkDiff ("pales", "paes"));
		System.out.println (checkDiff ("pale", "palersddd"));
	}

}
