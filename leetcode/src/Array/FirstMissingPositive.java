package Array;
/**
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 * @author heguangliu
 *
 */
public class FirstMissingPositive{
	public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A == null|| A.length ==0)
			return -1;
		int length = A.length;
		for(int i=0; i<length; i++){
			if(A[i] < 0)
				A[i] = length+2;
		}
		//hash array, A[i] pos/neg indicate the presence of i+1
		for(int i=0; i<length; i++){
			int tmp = A[i];
			if(tmp < length)
				A[tmp]= -Math.abs(A[tmp]);
		}
        return -1;
    }
}