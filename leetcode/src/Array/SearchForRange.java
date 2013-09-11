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
	
	public int[] searchRange(int[] A, int target){
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
	// buggy version, but need furtehr modification
	/*
	public int[] searchRange(int[] A, int target) {
		int result[] ={-1, -1};
        if(A == null)
        	return result;
        if(A.length == 0)
        	return result;
        result[0]= findMinIndex(A, 0, A.length, target);
        result[1]= findMaxIndex(A, 0, A.length, target);
        return result;
    }
	
	public int findMinIndex(int A[], int start, int end, int target){
		int mid=(start + end)/2;
		if(start > end)
			return -1;
		if(A[mid] > target){
			return findMinIndex(A, start, mid-1, target);
		}else if(A[mid] < target){
			return findMinIndex(A, mid+1, end, target);
		}else{
			if(mid==0){
				return A[mid]==target? mid:-1;
			}else if(A[mid]==target && A[mid-1]!=target){
				return mid;
			}
			end = mid-1 ;
			mid = (start+ end)/2;		
			int left =findMinIndex(A, start, mid-1, target);
			if(left == -1){
				if(A[mid]==target){
					return mid;
				}else{
					int right = findMinIndex(A, mid+1, end, target);
					return right==-1? end+1:right;
				}
			}else{
				return left;
			}
		}
	}
	public int findMaxIndex(int A[], int start, int end, int target){
		int mid=(start+end)/2;
		if(start > end)
			return -1;
		if(A[mid] > target){
			return findMaxIndex(A, start, mid-1, target);
		}else if(A[mid] < target){
			return findMaxIndex(A, mid+1, end, target);
		}else{
			if(mid == A.length-1){
				return A[mid]==target? mid:-1;
			}else if(A[mid]==target && A[mid+1]!=target){
				return mid;
			}
			start = mid+1;
			mid = (start + end)/2;
			int right = findMaxIndex(A, mid+1, end, target);
			if(right == -1){
				if(A[mid]== target){
					return mid;
				}else{
					int left = findMaxIndex(A, start, end, target);
					return left==-1? start-1: left;
				}
			}else
				return right;
		}
	}
	*/
}