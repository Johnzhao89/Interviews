package Array;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order. You may assume no duplicates in the array. Here are few examples.
 * [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4 [1,3,5,6], 0 ¡ú 0
 * 
 * @author heguangliu
 * 
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int start = 0;
		int end = A.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end)/2;
			if (A[mid] == target)
				return mid;
			else if (A[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(A[mid]< target)
			return mid+1;
		else
			return mid;
	}
}