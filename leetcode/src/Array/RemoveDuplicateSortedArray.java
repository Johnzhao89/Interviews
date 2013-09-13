package Array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory. For example, Given input array A = [1,1,2], Your function
 * should return length = 2, and A is now [1,2].
 * 
 * @author heguangliu
 * 
 */
public class RemoveDuplicateSortedArray {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return 1;
		
		int i = 1;
		for (int j = 1; j < A.length; j++) {
			if (A[j] != A[i - 1]) {
				A[i++] = A[j];
			}
		}
		return i;
	}
}