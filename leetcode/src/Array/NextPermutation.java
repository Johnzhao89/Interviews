package Array;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
 * @author heguangliu
 *
 */
import java.util.*;
public class NextPermutation{
	public void nextPermutation(int[] num) {
        if(num == null || num.length < 2)
        	return;
        if(num.length == 2){
        	 swap(num, 0, 1);
        	 return;
        }
        //find first Smaller
       for(int i=num.length -1; i>=0; i--){
    	   for(int j= i-1; j>=0; j--){
    		   if(num[j] < num[i]){
    		   swap(num, i, j);
    		   Arrays.sort(num, j+1, num.length);
    		   return;
    		   }
    	   }
       }
       Arrays.sort(num);
    }
	public void swap(int[] num, int a, int b){
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}

}