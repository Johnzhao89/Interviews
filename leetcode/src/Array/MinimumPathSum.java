package Array;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
   Note: You can only move either down or right at any point in time.
 * @author heguangliu
 *
 */
public class MinimumPathSum{
	public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m+1][n+1];
        for(int i=0; i<=m;i++)
        	for(int j=0; j<=n; j++)
        		matrix[i][j] =-1;
        return minPathSumHelper(m,  n, matrix, grid);
    }
	
	public int minPathSumHelper(int a, int b, int[][] matrix, int[][] grid){
		if(a == 1 && b == 1)
			return grid[0][0];
		if(a < 1 || b < 1)
			return Integer.MAX_VALUE;// Caution!
		if(matrix[a-1][b] == -1)
			matrix[a-1][b]=minPathSumHelper(a-1, b, matrix, grid);
		if(matrix[a][b-1] == -1)
			matrix[a][b-1]=minPathSumHelper(a, b-1, matrix, grid);
		return Math.min(matrix[a-1][b], matrix[a][b-1])+grid[a-1][b-1];
	}
}