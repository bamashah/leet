package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 */
public class MergeIntervals {
	
    static List<Interval> result = new ArrayList<Interval>();
    
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;        
        Collections.sort(intervals, new IntervalComparator());
        recurse(intervals);    
        return result;
    }
    
    public static void recurse (List<Interval> intervals) {
        
        if (intervals.size() == 1) {
            result.add(intervals.remove(0));  
            return;
        }
        
        Interval first = intervals.get(0); 
        Interval second = intervals.get(1); 
        
        if (second.start <= first.end) {
            Interval combined = new Interval(first.start, Math.max(first.end,second.end));
            intervals.remove(0);
            intervals.remove(0);
            intervals.add(0, combined);
        } else {
            result.add(intervals.remove(0));            
        }
        
        recurse(intervals);
    }
    
	public static void main(String[] args) {
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);list.add(i2);list.add(i3);list.add(i4);
		
		System.out.println(merge(list));

	}

}

class IntervalComparator implements Comparator<Interval>{

	public int compare(Interval firstInt, Interval secondInt) {
		int retval = 0;
		
		if (firstInt.start > secondInt.start) {
			retval =  1;
		} else if (firstInt.start < secondInt.start) {
			retval =  -1;
		} 
		
		return retval;
	}
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}