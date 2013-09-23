package Array;
/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
For example,
Given n = 3,
You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author heguangliu
 *
 */
public class SpiralMatrixII{
	public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        int start =0, end =n-1;
        int num =1;
        while(start < end){
        	for(int j= start; j< end; j++){
        		matrix[start][j] = num++;
        	}
        	for(int i= start; i< end; i++){
        		matrix[i][end]=num++;
        	}
        	for(int j = end; j> start; j--){
        		matrix[end][j]=num++;
        	}
        	for(int i= end; i> start; i--){
        		matrix[i][start]=num++;
        	}
        	start++;
        	end--;
        }
        if(start == end){
        	matrix[start][end]=num;
        }
        return matrix;
    }
}