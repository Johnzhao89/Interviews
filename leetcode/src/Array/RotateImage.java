package Array;

/**
 * You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?
 * @author heguangliu
 *
 */
public class RotateImage{
	public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null || matrix.length == 0)
        	return;
        int l = matrix.length;
        int start = 0, end = matrix.length -1;
        while(start < end){
        	for(int i=0; i<end - start; i++){
        		int temp =matrix[start+i][end];
        		matrix[start+i][end]= matrix[start][start+i];
        		matrix[start][start+i]= matrix[end-i][start]; 
        		matrix[end -i][start]= matrix[end][end-i];
        		matrix[end][end-i]=temp;
        	}
        	start++;
        	end--;
        }
    }
}