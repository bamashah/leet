package arrays2d;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 *
 */
public class Islands {
	
    public static int getNumberOfIslands(char[][] grid) {
        if (grid.length == 0) return 0;
                
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == '1') {
                    count++;
                    dfs (i, j, grid);
                }
            }
        }
        
        return count;
    }
    
    public static void dfs(int x, int y, char[][] grid) {
        grid[x][y] = 'v';
        int nextx = x-1; 
        int nexty = y;
        
            
        if (!(isOutOfBounds(nextx,nexty,grid)) && (grid[nextx][nexty] == '1'))
            dfs(nextx, nexty, grid);

        nextx = x+1; 
        nexty = y;
        
        if (!(isOutOfBounds(nextx,nexty,grid)) && (grid[nextx][nexty] == '1'))
            dfs(nextx, nexty, grid);
        
        nextx = x; 
        nexty = y-1;
        
        if (!(isOutOfBounds(nextx,nexty,grid)) && (grid[nextx][nexty] == '1'))
            dfs(nextx, nexty, grid);

        nextx = x; 
        nexty = y+1;
        
        if (!(isOutOfBounds(nextx,nexty,grid)) && (grid[nextx][nexty] == '1'))
            dfs(nextx, nexty, grid);
        
    }
    
    public static boolean isOutOfBounds(int x, int y, char[][] grid) {
        if (x < 0) return true;
        if (y < 0) return true;
        if (x >= grid.length) return true;
        if (y >= grid[0].length) return true;
        
        return false;
    }
	public static void main(String[] args) {
		char[] arr1 = {'1','1','0','0','0'};
		char[] arr2 = {'1','1','0','0','0'};
		char[] arr3 = {'0','0','1','0','0'};
		char[] arr4 = {'0','0','0','1','1'};
		char[][] arr = {arr1, arr2, arr3, arr4};
		System.out.println(getNumberOfIslands(arr));
	}

}
