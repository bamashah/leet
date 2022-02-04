package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * 1. Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * 2. Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * 
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * What is the total amount of fruit you can collect with this procedure?
 *
 * Given [1,2,1], we can collect [1,2,1], which the length is 3.
 * Given [0,1,2,2], we can collect [1,2,2], which the length is 3.
 * Given [1,2,3,2,2], we can collect [2,3,2,2], which the length is 4.
 * Given [3,3,3,1,2,1,1,2,3,3,4], we can collect [1,2,1,1,2], which the length is 5.
 * 
 * This is similar to the LongestSubstringTwoChars problem under strings
 */
public class FruitIntoBaskets {

    public static int totalFruit(int[] tree) {
        if (tree.length < 3) return tree.length;
        
        Set<Integer> set = new HashSet<Integer>();
        int max = 0;
        int i = 0;
        int transition = 0;
        int prev = tree[0];
        int basket = 0;
        
        while (i < tree.length) {
            int fruit = tree[i];
            
            if ((set.contains(fruit)) || (set.size() < 2)) {
                set.add(fruit);
                basket++;
                max = Math.max(max, basket);
                
                if (fruit != prev) {
                    transition = i;
                    prev = fruit;
                }
                
                i++;
            } else {
                basket = 0;
                set = new HashSet<Integer>();
                prev = tree[i=1];
                i = transition;
            }
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		int[] a = {1,2,1};
		int[] b = {0,1,2,2};
		int[] c = {1,2,3,2,2};
		int[] d = {3,3,3,1,2,1,1,2,3,3,4};
		
		System.out.println ("a - " + totalFruit(a));
		System.out.println ("b - " + totalFruit(b));
		System.out.println ("c - " + totalFruit(c));
		System.out.println ("d - " + totalFruit(d));
	}

}
