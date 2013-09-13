package Array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
 * @author heguangliu
 *
 */
public class MergeSortedArray{
	public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A.length < m+n || B.length ==0 || n==0)
			return;
        int indexA = m-1, indexB = n-1, indexM = m+n-1;
        while(indexA>=0 && indexB >=0 ){
        	A[indexM--] = A[indexA] > B[indexB]? A[indexA--] : B[indexB --];
        }
        while(indexB>=0){
        	A[indexM--] = B[indexB--];
        }
    }
}