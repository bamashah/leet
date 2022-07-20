package arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * 
 * determine if one person could attend all meetings (assuming they cannot be in two meetings at the same time).
 *
 * Input: [[0,30],[5,10],[15,20]] 
 * Output: false
 * 
 * Input: [[7,10],[2,4]]
 * Output: true
 *
 */
public class MeetingRooms {
	
    public static boolean canAttendMeetings(int[][] intervals) {
        // sort the list by meeting start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i+1][0] < intervals[i][1])
                return false;
        }

        return true;
    }

	public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
		System.out.println(canAttendMeetings(intervals));
	}

}
