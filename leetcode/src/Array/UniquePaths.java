package Array;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there? Above is a 3 x 7 grid. How many
 * possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * @author heguangliu
 * 
 */
public class UniquePaths {
	//backward, bad version, many recalculate
	public int uniquePaths2(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == 1 && n == 1)
			return 1;
		if (m < 1 || n < 1)
			return 0;
		return uniquePaths2(m - 1, n)+ uniquePaths2(m, n - 1);
	}
	
	// improve with memory version
	public int uniquePaths1(int m, int n){
		int[][] matrix = new int[m+1][n+1];
		for(int i=0; i< m+1; i++)
			for(int j =0; j< n+1; j++){
				matrix[i][j] = -1;
			}
		return uniquePathsHelper(matrix, m , n);
	}
	public int uniquePathsHelper(int[][] matrix, int a, int b){
		if(a == 0 || b == 0)
			return matrix[0][0]=1;
		if( a < 0|| b < 0)
			return 0;
		if(matrix[a-1][b] == -1)
			matrix[a-1][b]= uniquePathsHelper(matrix, a-1, b);
		if(matrix[a][b-1] == -1)
			matrix[a][b-1] = uniquePathsHelper(matrix, a, b-1);
		return matrix[a-1][b]+ matrix[a][b-1];
	}
	
	// much better one
	public int uniquePath(int m, int n){
		int x = Math.min(m, n);
		int y = Math.max(m, n);
		int[] ret = new int[x];
		for(int i = 0; i< x; i++)
			ret[i] = 1;
		for(int i = 1; i < y; i++)
			for(int j = 1; j < x; j++){
				ret[j]+= ret[j - 1];
			}
		return ret[x - 1];
	}

}