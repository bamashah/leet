package heap;

import java.util.Comparator;


class MaxComparator implements Comparator<Integer>{

	public int compare(Integer first, Integer second) {
		if (first < second) {
			return  1;
		} else  {
			return  -1;
		} 
	}
}