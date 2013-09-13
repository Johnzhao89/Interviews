package Array;

//Remove Element
//Given an array and a value, remove all instances of that value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class RemoveElement{
	public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length == 0)
        	return 0;
        int start = 0;
        int end =A.length -1;
        //end and start point to next item to check, 
        while(start <= end){
        	if(A[start]!= elem && A[end]!=elem){
        		start++;
        	}else if(A[start]!=elem && A[end]==elem){
        		start++;
        		end--;
        	}else if(A[start]==elem && A[end]==elem){
        		end--;
        	}else{
        		shift(A, start, end);
        	}
        }
        return start;
   }
	
	public void shift(int[] A, int start, int end){
		int temp = A[start];
		A[start]=A[end];
		A[end]= temp;
	}
}