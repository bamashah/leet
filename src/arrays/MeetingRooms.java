package arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * 
 * (1) determine if one person could attend all meetings (assuming they cannot be in two meetings at the same time).
 *
 * Input: [[0,30],[5,10],[15,20]] 
 * Output: false
 * 
 *  Input: [[7,10],[2,4]]
 * Output: true
 * 
 * 
 * (2) find the minimum number of conference rooms required.
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRooms {
	
	// Solution to (1)
    public static boolean canAttendMeetings(Interval[] intervals) {
        int max = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].end > max)
                max = intervals[i].end;
        }
        
        
        int[] timeline = new int[max];
        
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            int start = interval.start;
            int end = interval.end;
            
            for (int j = start; j < end; j++) {
                if (timeline[j] != 1)
                    timeline[j] = 1;
                else
                    return false;
            }
        }        
        
        return true;
    }

    
	// Solution to (2)
    public static int minMeetingRooms(Interval[] intervals) {
        int max = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].end > max)
                max = intervals[i].end;
        }
        
        
        int[] timeline = new int[max];
        
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            int start = interval.start;
            int end = interval.end;
            
            for (int j = start; j < end; j++) {
                timeline[j]++;
            }
        }        
        
        int rooms = 0;
        
        for (int i = 0; i < timeline.length; i++) 
            rooms = Math.max(rooms, timeline[i]);
        
        
        return rooms;        
    }
    
	public static void main(String[] args) {
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = {i1, i2, i3};
		
		System.out.println(canAttendMeetings(intervals));
		System.out.println(minMeetingRooms(intervals)); 
	}

}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}