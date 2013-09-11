package Array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray{
	public static int search(int A[], int target){
        if(A == null|| A.length ==0)
			return -1;
		return search(A, 0,A.length-1, target);
	}
	
	public static int search(int a[], int start, int end, int target){
		int mid = (start + end)/2;
		if(target == a[mid])
			return mid;
		else if(end < start)
			return -1;
		if(a[start] <= a[mid]){// left is normal order
			if(a[start] <= target && target <= a[mid]){
				return search(a,start, mid-1, target);
			}else{
				return search(a, mid+1, end, target);
			}
		}else {// right is normal order
			if(a[mid]< target && target <= a[end]){
				return search(a, mid+1, end, target);
			}else{
				return search(a, start, mid-1, target);
			}
		}
	}
}