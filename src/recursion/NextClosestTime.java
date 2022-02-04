package recursion;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * 
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
 * It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 * 
 *
 */
public class NextClosestTime {

    static int mindiff = Integer.MAX_VALUE;
    static String closestTime;
    
    public static String nextClosestTime(String time) {
        time = time.replace(":", "");
        closestTime = time;
        recurse (time, "", time);

        String cltime = closestTime.substring(0,2) + ":" + closestTime.substring(2,4);
        return cltime;
    }
    
    public static void recurse (String time, String permutation, String originalTime) {
        if (permutation.length() == 4) {
                        
            if (isTimeValid(permutation) && !permutation.equals(originalTime)) {
                calcDifference(permutation, originalTime);
            }
            
            return;
        }
        
        
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);            
            String newpermutation = permutation + c;
            recurse (time, newpermutation, originalTime);
        }
        
    }
    
    
    public static boolean isTimeValid(String time) {
        String h1 = time.substring(0,1);
        int h1int = Integer.parseInt(h1);
        
        if (h1int > 2) return false;
        
        if (h1int == 2) {
            String h2 = time.substring(1,2);
            int h2int = Integer.parseInt(h2);

            if (h2int > 3) return false;
            
        }
        

        String m1 = time.substring(2,3);
        int m1int = Integer.parseInt(m1);
        
        if (m1int > 5) return false;

        return true;
    }
    
    public static int calcDifference (String time, String original) {
        int diff = 0;
        
        int timemins = getMinutes(time);
        int originalmins = getMinutes(original);
        
        if (timemins - originalmins < 0) {
            diff = timemins + (1440-originalmins);
        } else
            diff = timemins - originalmins;
        
        if (diff < mindiff) {
            mindiff = diff;
            closestTime = time;
        }
        
        return diff;
        
    }
    
    public static int getMinutes (String time) {
        int hours = Integer.parseInt(time.substring(0,2));
        int mins = Integer.parseInt(time.substring(2));        
        return (60*hours)+mins;
    }
    
	public static void main(String[] args) {
		System.out.println(nextClosestTime("12:33"));

	}

}
