package Array;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @author heguangliu
 * 
 */
public class JumpGameII {
	// basically same, but better one, need only consider the boundary
	public int jump(int[] A) {
		if (A == null || A.length < 2)
			return 0;
		if (A == null || A.length < 2)
			return 0;
		int coverage = 0, last = 0, step = 0;
		for (int i = 0; i < A.length; i++) {
			if (last < i) {
				last = coverage;
				step++;
			}
			coverage = Math.max(coverage, i + A[i]);
		}
		return step;
	}

	// bad version, need fill minJump array for every element
	public int jump2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length < 2)
			return 0;
		int coverage = 0;
		int[] minJump = new int[A.length];
		Arrays.fill(minJump, -1);
		for (int i = 0; i < A.length && i <= coverage; i++) {
			coverage = Math.max(coverage, A[i] + i);
			if (coverage >= A.length - 1)
				return minJump[i] + 1;
			else {
				for (int j = i; j <= coverage; j++)
					if (minJump[j] == -1)
						minJump[j] = minJump[i] + 1;
			}
		}
		return minJump[A.length - 1];
	}

}