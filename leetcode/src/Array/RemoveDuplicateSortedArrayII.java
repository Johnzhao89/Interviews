package Array;

/**
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 * @author heguangliu
 *
 */
public class RemoveDuplicateSortedArrayII{
	
	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A == null)
			return 0;
		if(A.length <= 2)
			return A.length;
        int i = 2;
        for(int j=2; j<A.length; j++){
        	if(A[j] != A[i-1] || A[j] !=A[i-2]){
        		A[i++]=A[j];
        	}
        }
        return i;
    }
}