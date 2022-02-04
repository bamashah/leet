package arrays2d;

import java.util.ArrayList;
import java.util.List;

/**
 * Knight's tour problem
 * Given an m x n chessboard, if the position (x,y) of the knight is given, 
 * find the path which covers all the blocks of the chessboard without repeating.
 *
 */
public class KnightsTour {
	static int[] possibleMovesX = {1,-1,2,2,-1,1,-2,-2};
	static int[] possibleMovesY = {2,2,1,-1,-2,-2,-1,1};
	
	public static void dfs (int[][] board, List<Move> moves) {
		if (isFilled(board)) {
			System.out.println(moves);
			return;
		}
		
		Move last = moves.get(moves.size() - 1);
		int x = last.x;
		int y = last.y;
		
		for (int i = 0; i < possibleMovesX.length; i++) {
			int newX = x + possibleMovesX[i];
			int newY = y + possibleMovesY[i];
			
			if (isValidMove(board, newX, newY)) {
				int[][] newBoard = new int[board.length][board[0].length];
				
				for (int j = 0; j < board.length; j++) {
					newBoard[j] = board[j].clone();
				}
				
				
				List<Move> newMoves = new ArrayList<Move>(moves);
				newBoard[newX][newY] = 1;
				Move nextMove = new Move(newX,newY);
				newMoves.add(nextMove);
				
				dfs (newBoard,newMoves);
			}
		}
		
	}
	
	private static boolean isValidMove(int[][] board, int x, int y) {
		int m = board.length;
		int n = board[0].length;
		
		if (x < 0 || y < 0) return false;
		if (x >= m || y >= n) return false;
		
		if (board[x][y] == 1) return false;
		
		return true;
	}

	private static boolean isFilled(int[][] board) {
		for (int i = 0; i < board.length; i++) 
			for (int j = 0; j < board[i].length; j++)
				if (board[i][j] == 0) return false;
			
		return true;
	}
	
	
	public static void main (String[] args) {
		int[][] board = new int[3][3];
		board[1][1] = 1;
		Move m = new Move (0,0);
		List<Move> moves = new ArrayList<Move>();
		moves.add(m);
		dfs (board, moves);
	}
}

class Move {
	int x;
	int y;
	
	Move (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}