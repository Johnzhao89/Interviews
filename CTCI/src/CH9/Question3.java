package CH9;
import java.util.*;
import CtCILibrary.*;

public class Question3{
	public static int magicFast0(int[] array, int start, int end){
		if(end<start || start<0 || end>=array.length){
			return -1;
		}
		int mid=(start+end)/2;
		if(array[mid]==mid){
			return mid;
		}else if(array[mid]>mid){
			return magicFast0(array, start, mid-1);
		}else{
			return magicFast0(array, mid+1, end);
		}
	}
	
	public static int magicFast0(int[] array){
		return magicFast0(array, 0, array.length-1);
	}
	
	public static int magicFast1(int[] array, int start, int end){
		if(end< start || start<0 || end>= array.length){
			return -1;
		}
		int midIndex =(start+end)/2;
		int midValue = array[midIndex];
		if(midValue == midIndex){
			return midIndex;
		}
		int leftIndex = Math.min(midIndex -1, midValue);
		int left = magicFast1(array, start, leftIndex);
		if(left>=0){
			return left;
		}
		int rightIndex = Math.max(midIndex+1, midValue);
		int right = magicFast1(array, rightIndex, end);
		return right;
	}
	
	public static int magicFast(int[] array) {
		return magicFast1(array, 0, array.length - 1);
	}
}