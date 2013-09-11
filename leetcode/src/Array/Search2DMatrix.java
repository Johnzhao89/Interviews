package Array;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * @author heguangliu
 *
 */

public class Search2DMatrix{
	
	//good one O(log m + log n)
	public boolean searchMatrix(int[][] matrix, int target){
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0, end = m-1, mid =0;
		while(start <= end){
			mid = (start+ end)/2;
			int left = matrix[mid][0];
			int right = matrix[mid][n-1];
			if(left > target){
				end = mid-1;
			}else if(right < target){
				start = mid+1;
			}else{
				break;
			}
		}
		int left = 0;
		int right = n-1;
		while(left <= right){
			int middle = (left+right)/2;
			if(matrix[mid][middle]==target)
				return true;
			else if(matrix[mid][middle]>target){
				right =middle-1;
			}else{
				left = middle +1;
			}
		}
		return false;
	}
}