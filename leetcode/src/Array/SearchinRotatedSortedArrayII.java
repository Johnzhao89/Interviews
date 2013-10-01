package Array;

//worst time run time: O(N)

/*
* Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
*/
// passed
public class SearchinRotatedSortedArrayII{
	public static boolean search(int[] A, int target){
    	if(A == null)
			return false;
		if(A.length == 0)
			return false;
		return search(A, 0, A.length-1,target);
	}
	// array, start, end target, check mid, then recursively find in half
	public static boolean search(int[] A, int start, int end, int target){
		int mid = (start+ end)/2;
		if(A[mid]==target)
			return true;
		if(start > end)
			return false;
		if(A[start] < A[mid]){//left in order
			if(A[start] <= target && target<A[mid])
				return search(A, start, mid-1, target);
			else
				return search(A, mid+1, end, target);
		}else if(A[mid] < A[start]){
			if(A[mid]< target && target<= A[end]){
				return search(A, mid+1, end, target);
			}else
				return search(A, start, mid-1,target);
		}else{
			boolean findLeft=search(A, start, mid-1, target);
			return findLeft? findLeft: search(A, mid+1, end, target);
		}
	}
}