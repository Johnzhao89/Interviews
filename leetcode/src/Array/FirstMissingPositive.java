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

import java.util.*;
public class FirstMissingPositive{
	
	public int firstMissingPositive2(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A == null)// be cautious here
			return -1;
		int length = A.length;
		
		// set all the negative to n+2, n+2 is impossible
		for(int i=0; i<length; i++){
			if(A[i] <= 0)
				A[i] = length+2;
		}
		
		//hash array, A[i] pos/neg indicate the presence of i+1
		for(int i=0; i<length; i++){
			int tmp = Math.abs(A[i]);
			if(tmp <= length)
				A[tmp-1]= -Math.abs(A[tmp-1]);
		}
		// find first positive number
		for(int i=0; i< length; i++){
			if(A[i] > 0)
				return i+1;
		}
        return length+1;
    }
	
	public int firstMissingPositive(int[] A){
		int length = A.length >> 3 +1;
		BitSet s = new BitSet(length);
		for(int a: A){
			if(a > 0 && a<= length )
				s.set(a);
		}
		return s.nextClearBit(1);
	}
	
}