package arrays2d;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * For example,
 * Given 2d vector =
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: 1,2,3,4,5,6
 */
public class Vector2D  {

    int x, y;
    List<List<Integer>> list;
    
    public Vector2D(List<List<Integer>> vec2d) {
        x = 0;
        y = 0;
        list = vec2d;

    	while (x < list.size() && list.get(x).size() == 0) {
    		x = x + 1;
    	}
    }

    public Integer next() {
        int result = list.get(x).get(y);

        if ((y+1) < list.get(x).size()) {
            y = y+1;
        } else {
        	do {
        		x = x + 1;
        	} while (x < list.size() && list.get(x).size() == 0);
        	
            y = 0;
        }
        
        return result;
    }
    
    public boolean hasNext() {
        boolean result = false;
        
        if (x < list.size() && y < list.get(x).size()) {
            result = true;            
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(4);list3.add(5);list3.add(6);
		list.add(list1);list.add(list2);list.add(list3);
		
		Vector2D i = new Vector2D(list);
		while (i.hasNext()) 
			System.out.print (i.next() + " ");		
	}

}
