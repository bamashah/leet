package arrays;

import java.util.Arrays;

/*
 * Run the program like this:
 * java Pyramid <height>
 * expects numerical value for height. if height is not provided, the default height is 5.
 */
public class Pyramid{
  static int height = 6; //hard coded height
  static char[] line;

  public static void buildBase(int i){
     Arrays.fill(line,height-1-i,height+i,'*');
     System.out.println(new String(line));
     if (i < height-1) {
    	 buildBase(i+1); //recursion
     }   
  }

  public static void main(String[] args){
	  line = new char[2*height];
	  Arrays.fill(line,0,height,' ');
	  buildBase(0);
  }

}