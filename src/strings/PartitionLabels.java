package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. 
 * We want to partition this string into as many parts as possible 
 * so that each letter appears in at most one part
 * Return a list of integers representing the size of these parts.
 * 
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int end = 0;
        int i = 0;
        
        while (i < S.length()) {
            char c = S.charAt(i);
            
            int nextindex = S.indexOf(c, i+1);
            end = Math.max(end, nextindex);
            
            if (i == end) {
                list.add(end-start+1);
                start = end + 1;
                end = start;
            }
            
            i++;
        }
        
        return list;
    }
    
	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(s));
	}

}
