package Array;
/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at 
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
  Note: You may not slant the container.
 * @author heguangliu
 *
 */
// passed
public class ContainerWithMostWater{
	public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxArea = 0;
        if(height == null||height.length <2){
        	return maxArea;
        }
        int left =0;
        int right = height.length -1;
        while(left < right){
        	int h = height[left] < height[right]? height[left]: height[right];
        	int currentArea = h* (right - left);
        	maxArea = currentArea > maxArea? currentArea: maxArea;
        	if(height[left] < height[right]){
        		left++;
        	}else{
        		right --;
        	}
        }
        return maxArea;
    }
}