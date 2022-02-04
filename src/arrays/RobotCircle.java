package arrays;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, 
 * which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character. 
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
 * The output should be true or false representing whether the robot makes a circle.
 *
 * Input: "UD", Output: true
 * Input: "LL", Output: false
 */
public class RobotCircle {
	
    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        
        char[] m = moves.toCharArray();
        
        for (int i=0;i<m.length;i++) {
            char move = m[i];
            
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }
        
        if (x == 0 && y == 0) 
            return true;
        else
            return false;
    }
	public static void main(String[] args) {
		System.out.println (judgeCircle("ULDR"));
		System.out.println (judgeCircle("LL"));
	}

}
