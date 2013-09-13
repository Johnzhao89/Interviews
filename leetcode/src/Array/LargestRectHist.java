package Array;
import java.util.*;
public class LargestRectHist{
	public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		Stack<Integer> s = new Stack<Integer>();
		int maxArea=0, topArea;
		int i=0;
		int tp=0;
		while(i < height.length){
			// If this bar is higher than the bar on top stack, push it to stack
			if(s.isEmpty()||height[s.peek()]<=height[i])
				s.push(i++);
			else{
				// If this bar is lower than top of stack, then calculate area of rectangle 
		        // with stack top as the smallest (or minimum height) bar. 'i' is 
		        // 'right index' for the top and element before top in stack is 'left index'
				tp = s.peek();
				s.pop();
				topArea = height[tp]*(s.isEmpty()? i: i - s.peek()-1);
				if(maxArea< topArea)
					maxArea = topArea;
			}
		}
		while(!s.isEmpty()){
			tp= s.pop();
			topArea = height[tp]*(s.isEmpty()? i: i-s.peek() -1);
			if(maxArea< topArea)
				maxArea = topArea;
		}
		return maxArea;
    }
	
	public int largestRestangleArea1(int[] height){
		if(height.length==0) return 0;
        int max=0;
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(height[0]);
        for(int i=1;i<height.length;i++){
            if(height[i]>=height[i-1]){
                stack.push(height[i]);
            }else{
                int count=1;
                while(!stack.isEmpty()&&height[i]<stack.peek()){
                    int cur=stack.pop();
                    max=Math.max(max,cur*count);
                    count++;
                }
                for(int j=0;j<count;j++){
                    stack.push(height[i]);
                }
            }
        }
        int count=1;
        int len=stack.size();
        for(int i=0;i<len;i++){
            int temp=stack.pop();
            max=Math.max(max,temp*count);
            count++;
        }
        return max;
	}
}
