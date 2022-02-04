package arrays;

import java.util.ArrayList;

/** 
 * Sort a list using QuickSort technique
 */
public class QuickSort {

	private static ArrayList<Integer> sort (ArrayList<Integer> data) {
		if (data.size() <= 1) {
			return data;
		}
		  
		int midIndex = Math.round(data.size()/2);
		int middle = data.get(midIndex);
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for (int i = 0; i < data.size(); i++) {
			if (i != midIndex) {
				int currentData =  data.get(i);
		     
				if (currentData <= middle)
					left.add(currentData);
		        else
		        	right.add(currentData);
		     }
		}
		
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		returnList.addAll(sort(left));
		returnList.add(middle);
		returnList.addAll(sort(right));
		  
		return returnList;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> n = new ArrayList<Integer>();
		n.add(45); n.add(23); n.add(11); n.add(89); n.add(77); n.add(98); n.add(23); 
		n.add(21); n.add(9); n.add(1); n.add(33); n.add(4); n.add(65); n.add(43);
				
		ArrayList<Integer> sortedList = sort(n);
		System.out.print(sortedList);
	}

}
