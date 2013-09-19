package Array;

/**
 * Given n non-negative integers representing an elevation map where the 
 * width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author heguangliu
 *
 */
public class TrappingRainWater{
	
	public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A==null || A.length <=2)
			return 0;
		int[] leftMax = new int[A.length];
		int water=0;
		leftMax[0] = A[0];
		for(int i=1; i< A.length ; i++){
			leftMax[i] = leftMax[i-1] > A[i]? leftMax[i-1] : A[i];
		}
		
		int[] rightMax = new int[A.length];
		rightMax[A.length-1]= A[A.length-1];
		for(int i = A.length-2; i >= 0; i--){
			rightMax[i] = rightMax[i+1] > A[i] ? rightMax[i+1]: A[i];
			water+= Math.max(Math.min(leftMax[i], rightMax[i])-A[i], 0);
		}
		return water;
    }
}