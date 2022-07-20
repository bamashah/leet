package arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 *
 * find the minimum number of conference rooms required.
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {

        // sort the list by meeting start times
        int[] starts = new int[intervals.length];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
        }

        // sort the list by meeting end times
        int[] ends = new int[intervals.length];
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < intervals.length; i++) {
            ends[i] = intervals[i][1];
        }

        // use two pointers to go over the start and end times arrays
        int maxMeetingRooms = 0;
        int meetingRooms = 0;
        int x = 0, y=0;
        while (x < starts.length && y < ends.length) {
            if (starts[x] < ends[y]) {
                meetingRooms++;
                maxMeetingRooms = Math.max(maxMeetingRooms, meetingRooms);
                x++;
            } else {
                //a meeting has ended. release a meeting room.
                meetingRooms--;
                y++;
            }
        }

        return maxMeetingRooms;
    }
    
	public static void main(String[] args) {
		int[][] intervals = {{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(intervals));
	}

}

