package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given an array of strings, group anagrams together.
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 */
public class AnagramGrouping {
    public static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        
        for (String str:strs) {
            int hash = getHash(str);
            
            if (map.containsKey(hash))
                map.get(hash).add(str);
            else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(hash, list);
            }
        }
        
        List<List<String>> retval = new ArrayList<List<String>>();
            
        for (List<String> l : map.values()) {
            retval.add(l);
        }
        
        return retval;
    }
    
    public static int getHash (String str) {
        int hash = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            hash = hash * primes[c - 'a'];
        }
        
        return hash;
    }
    
	public static void main(String[] args) {
		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(arr));
	}

}
