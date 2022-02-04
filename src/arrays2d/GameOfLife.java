package arrays2d;

public class GameOfLife {
		
	
	static int gridSize = 8;
	static int currentGenGrid[][] = new int[gridSize][gridSize];
	static int nextGenGrid[][] = new int[gridSize][gridSize];
	
	static void initialize() {
		for (int i = 0; i<gridSize; i++) {
			for (int j = 0; j<gridSize; j++) {
				currentGenGrid[i][j] = 0;
				nextGenGrid[i][j] = 0;
			}
		}		
	}
	
	static void seed() {
		currentGenGrid[1][2] = 1;
		currentGenGrid[1][3] = 1;
		currentGenGrid[1][4] = 1;
	}
	
	static void printGrid() {
		for (int i = gridSize-1; i>=0; i--) {
			for (int j = 0; j<gridSize; j++) {
				System.out.print(currentGenGrid[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
	}
	
	static int countLiveNeighbors(int i, int j) {
		int livecount = 0;
		
		for (int a=i-1; a<=i+1; a++) {
			for (int b=j-1; b<=j+1; b++) {
				if ((a == i) && (b == j)) {
					// do nothing
				} else if ((a<0) || (a>gridSize-1) || (b<0) || (b>gridSize-1)) {
					// do nothing				
				} else {
					if (currentGenGrid[a][b] == 1) {
						livecount++;
					}
				}
			}
		}
		
		//System.out.println(i + "," + j + " - " + livecount);
		return livecount;
	}
	
	static void tick() {
		for (int i = 0; i<gridSize; i++) {
			for (int j = 0; j<gridSize; j++) {
				int currentCell = currentGenGrid[i][j];
				int livecount = countLiveNeighbors(i,j);
				if (currentCell == 1) {
					// it's alive
					if (livecount<2) {
						nextGenGrid[i][j] = 0;
					} else if (livecount > 3) {
						nextGenGrid[i][j] = 0;						
					} else {
						nextGenGrid[i][j] = 1;												
					}
				} else {
					// it's dead
					if (livecount==3) {
						nextGenGrid[i][j] = 1;
					}					
				}
			}
		}		
		
		copy();
	}
	
	static void copy() {
		for (int i = 0; i<gridSize; i++) {
			for (int j = 0; j<gridSize; j++) {
				currentGenGrid[i][j] = nextGenGrid[i][j];
				nextGenGrid[i][j] = 0;
			}
		}			
	}
	
	public static void main(String[] args) {
		// Game of Life
		initialize();
		seed();
		printGrid();

		while (true) {
			tick();
			printGrid();
		}
	}

}
