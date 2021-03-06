package strings;

import java.util.ArrayList;



//Suppose we abstract our file system by a string in the following manner:
//
//	The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
//
//	dir
//	    subdir1
//	    subdir2
//	        file.ext
//	The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
//
//	The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
//
//	dir
//	    subdir1
//	        file1.ext
//	        subsubdir1
//	    subdir2
//	        subsubdir2
//	            file2.ext
//	The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
//
//	We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
//
//	Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
//
//	Note:
//	The name of a file contains at least a . and an extension.
//	The name of a directory or sub-directory will not contain a .


public class LongestFilePath {

    public static int lengthLongestPath(String input) {
    	String[] tokens = input.split("\n"); 
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int max = 0;
    	
    	for (String token : tokens) {
    		int level = getLevel(token);
    		int tokenlength = token.length()-level; // discount the spaces used for \t
    		if (level > 0) tokenlength++;  // for the \ seperator
    		
    		int filesize = 0;
    		if (token.indexOf(".") != -1) {
    			// is a file
    			filesize = tokenlength;
    		} else {  
    			// is a directory
	    		if (list.size() <= level)
	    			list.add(level, tokenlength);
	    		else {
	    			list.set(level, tokenlength);
	    		}
    		}
    		
    		int totallength = 0;
    		
    		for (int len : list) 
    			totallength = totallength + len; // calc total length with various direstories
    		
    		totallength = totallength + filesize;
    		if (totallength > max) 
    			max = totallength;
    		
    		//System.out.println(token + " - " + totallength);
    	}
    	
    	
    	return max;
    }
    
    
    private static int getLevel(String s) {
    	String t = s.replace("\t", "");
    	return s.length() - t.length();
    }
    
	public static void main(String[] args) {
		System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

	}
	


}
