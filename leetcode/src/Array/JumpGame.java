package Array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
 * @author heguangliu
 *
 */
public class JumpGame{
	public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length ==0)
        	return false;
        if(A.length == 1)
        	return true;
        int coverage =0;
        for(int i=0; i< A.length && i<=coverage; i++)// Caution! i<= coverage
        	coverage = Math.max(coverage, A[i]+i);
        return coverage >= A.length -1;
    }
}