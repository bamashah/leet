package arrays2d;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left corner of the grid with r rows and c columns
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot 
 * cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right. 
 *
 */

public class RobotInGrid {
	static int r = 4;
	static int c = 5;
	static int grid[][] = new int[r][c];
	static List<List<String>> solutions = new ArrayList<List<String>>();
	
	static void initialize() {
		for (int i = 0; i<r; i++) {
			for (int j = 0; j<c; j++) {
				grid[i][j] = 1;
			}
		}		
	}	
	
	static void seed() {
		grid[0][1] = 0;
		grid[1][1] = 0;
		grid[2][3] = 0;
	}	
	
	static void printGrid() {
		for (int i = 0; i<r; i++) {
			for (int j = 0; j<c; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
	}	
	

	public static void recurse (int row, int col, ArrayList<String> list) {
		ArrayList<String> newList = new ArrayList<String>(list);
		newList.add("(" + row + "," + col + ")");
		
		if ((row == r-1) && (col == c-1)) {
			solutions.add(newList);
			return;
		} else if ((row >= r) || (col >= c)) {
			return;
		} else if (grid[row][col] == 0) {
			return;
		}
		
		recurse (row+1, col, newList);
		recurse (row, col+1, newList);

	}

	public static void main(String[] args) {
		initialize();
		seed();
		printGrid();
		recurse (0,0, new ArrayList<String>());
		
		for (List<String>solution : solutions) {
			System.out.println (solution);
		}
		
	}
		
}
