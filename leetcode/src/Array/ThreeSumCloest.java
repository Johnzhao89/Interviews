package Array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that
 *  the sum is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author heguangliu
 */
public class ThreeSumCloest{
	 public int threeSumClosest(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 Arrays.sort(num);
		 if(num.length <3)
			 return 0;
		 int closest = num[0]+num[1]+num[2];
		 for(int i=0; i< num.length; i++){
			 int left = 0;
			 int right = num.length -1;
			 while(left< right){
				 if(left == i){
					 left++;
					 continue;
				 }
				 if(right == i){
					 right--;
					 continue;
				 }
				 int sum = num[i]+ num[left]+num[right];
				 if(sum == target)
					 return target;
				 if(sum < target){
					 if(target - sum < Math.abs(target - closest))
						 closest = sum;
					 left++;
					 continue;
				 }
				 if(sum > target){
					 if(sum - target < Math.abs(target- closest))
						 closest = sum;
					 right --;
					 continue;
				 }
			 }
		 }
		 return closest;
	 }
}