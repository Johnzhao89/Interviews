package Array;
/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * @author heguangliu
 *
 */
//hard to think.. passed
import java.util.*;
public class MaximalRectangle{
	public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0){
        	return 0;
        }
        int m = matrix.length, n=matrix[0].length, max =0;
        int[] heights = new int[n];
        for(int i=0; i< m; i++){
        	for(int j=0; j<n; j++){
        		if(matrix[i][j]=='1'){
        			heights[j]++;
        		}else{
        			heights[j] = 0;
        		}
        	}
        	max = Math.max(max, maxHistoArea(heights));
        }
        return max;
    }
	
	public int maxHistoArea(int[] heights){
		class Ele{
			int h;
			int i;
			public Ele(int h, int i){
				this.h = h;
				this.i =i;
			}
		}
		Stack<Ele> st = new Stack<Ele>();
		int max =0, i =0;
		for( i =0; i< heights.length ; i++){
			if(st.isEmpty() || heights[i]> st.peek().h){
				st.push(new Ele(heights[i],i));
			}else if(heights[i]< st.peek().h){
				int prev =0;
				while(!st.empty() && heights[i] < st.peek().h){
					Ele e = st.pop();
					prev = e.i;
					max = Math.max(max, e.h*(i-e.i));
				}
				st.push(new Ele(heights[i], prev));
			}
		}
		while(!st.isEmpty()){
			Ele e = st.pop();
			max = Math.max(max, e.h*(i-e.i));
		}
		return max;
	}
}