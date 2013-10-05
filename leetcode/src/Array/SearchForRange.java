package Array;
/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * @author heguangliu
 *
 */
// passed
public class SearchForRange{
	// bad version
	public int[] searchRange2(int[] A, int target){
		int n = A.length;
		int start =0, end = n-1;
		int[] result ={-1, -1};
		while(start<=end){
			int mid = (end + start)/2;
			if(A[mid]< target){
				start = mid+1;
			}else if(A[mid] > target){
				end = mid-1;
			}else{
				result[0]= mid;
				result[1]=mid;
				for(int i = mid-1; i>=0; i--){
					if(A[i]== target)
						result[0]=i;
				}
				for(int j =mid+1; j<A.length; j++){
					if(A[j] == target)
						result[1]=j;
				}
				return result;
			}
		}
		return result;
	}
	//
	public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] invalid = {-1,-1};
        if(A == null) return invalid;
        int left =  searchLeft(0, A.length -1, A, target, true);
        int right =  searchLeft(0, A.length -1, A, target, false);
        int[] result = {left, right};
        return result;
    }
	// flag to distinguish the ways to deal with mid== target 
    private int searchLeft(int i, int j, int[] A, int target, boolean left){
		if(i>j) return -1;
		int mid = (i+j) / 2;
		if(A[mid] == target){
			if( ((mid == i ||A[mid-1] < target) && left) || ((mid == j ||A[mid+1] > target) && !left)){
				return mid;
			}
			if((left)){
				return searchLeft(i, mid - 1, A, target, left);
			}
			else{
				return searchLeft(mid+1, j, A, target, left);
			}
		}
		else if(A[mid] > target){
			return searchLeft(i, mid - 1, A, target, left);
		}
		else{ //(A[mid] < target)
			return searchLeft(mid +1, j, A, target, left);
		}
	}

}