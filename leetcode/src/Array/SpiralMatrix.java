package Array;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * @author heguangliu
 *
 */
import java.util.*;
public class SpiralMatrix{
	// matrix outside to inside, layer is ver important
	public static  ArrayList<Integer> spiralOrder(int[][] matrix){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(matrix== null || matrix.length == 0)
			return result;
		int m = matrix.length, n= matrix[0].length;
		int rowStart = 0, rowEnd = m-1, colStart = 0, colEnd = n-1;
		while(rowStart <= rowEnd && colStart <= colEnd){
			spiralOrderHelper(matrix, rowStart, rowEnd, colStart, colEnd, result);
			rowStart++; colStart++;
			rowEnd --; colEnd--;
		}
		return result;
	}
	
	public static void spiralOrderHelper(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, ArrayList<Integer> result){
		for(int i= rowStart, j= colStart; j<= colEnd; j++)
			result.add(matrix[i][j]);
		for(int i=rowStart+1, j=colEnd; i<=rowEnd; i++)
			result.add(matrix[i][j]);
		for(int i = rowEnd, j= colEnd-1; i>rowStart&& j>=colStart;j--)
			result.add(matrix[i][j]);
		for(int i= rowEnd-1, j= colStart; j<colEnd&& i>rowStart; i--)
			result.add(matrix[i][j]);
	}
	public static void main(String[] args){
		int[][] test = {{1}};
		System.out.println(spiralOrder(test));
	}
}