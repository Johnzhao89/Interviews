package Array;

/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * @author heguangliu
 *
 */
public class MaximumSubarray{
	// very step have two choice, restart or continue
	 public int maxSubArray(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int max =A[0];
	        int sum =A[0];
	        for(int i=0; i< A.length; i++){
	        	sum = Math.max(A[i], sum+ A[i]);
	        	max = Math.max(max, sum);
	        }
	        return max;
	 }
}