package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 */
public class WordLadder {

	// Uses bfs
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> q = new LinkedList<String>();
		Queue<Integer> levels = new LinkedList<Integer>();
		Set<String> visited = new HashSet<String>();
        
		q.add(beginWord);
		levels.add(0);
				
		while (!q.isEmpty()) {
			String s = q.remove();
			int level = levels.remove(); 
            
			if (endWord.equals(s)) {
				return level+1;
			}
			
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);

                if ((!visited.contains(word)) && (exactlyOneAlphaDiff(s, word))) {
                    q.add(word);
                    levels.add(level + 1);
                    visited.add(word);
                }
            }            			
		}
		
		return 0;
    }
    
        
    public static boolean exactlyOneAlphaDiff (String word1, String word2) {
        int size = word1.length();
        int diff = 0;
        for (int i = 0; i < size; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            
                if (diff > 1)
                    break;
            }
        }
        
        if (diff == 1) 
            return true;
        else
            return false;
    }
	
	public static void main(String[] args) {
		String beginword = "hit";
		String endword = "cog";
		String[] dictionary = {"hot","dot","dog","lot","log","cog"}; 

		System.out.println (ladderLength(beginword, endword, Arrays.asList(dictionary)));
	}

}
