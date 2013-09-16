package Array;
/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are 
 * adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.
 * @author heguangliu
 *
 */
public class SortColors{
	
	public void sortColors(int[] A) {
		if(A.length <=1 )
			return;
		
		int s = 0;
		
		int e = A.length -1;
		int t = 0;
		while(s <= e){
			if(A[s] == 2)
				swap(A, s, e--);// be careful here
			else if(A[s] == 0)
				swap(A, s++, t++);// t -> must be 0/1
			else if(A[s] == 1)
				s++;
		}
    }
	public static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}