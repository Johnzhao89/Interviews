package CommSS;
import java.util.*;
import CtCILibrary.*;

public class MergeSort extends AbstractSort{
	public void sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	public static void mergeSort(int[] array, int low, int high){
		if(low<high){
			int middle = (low + high)/2;
			mergeSort(array, low, middle);
			mergeSort(array, middle+1, high);
			merge(array, low, middle, high);
		}
	}
	
	public static void merge(int[] array, int low, int middle, int high){
		int[] helper= new int[array.length];
		for(int i= low; i<=high; i++){
			helper[i]= array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle+1;
		int current = low;
		
		while(helperLeft<=middle && helperRight <= high){
			if(helper[helperLeft]<=helper[helperRight]){
				array[current++]=helper[helperLeft];
				helperLeft++;
			}else{
				array[current++]=helper[helperRight];
				helperRight++;
			}
		}
		//CAUTIOUS!!!
		int remaining = middle - helperLeft;
		for(int i = 0; i<= remaining; i++){
			array[current+i]=helper[helperLeft+i];
		}
	}
	
	public static void main(String[] args) {
		int[] array = AssortedMethods.randomArray(20, 0, 19);
		int[] validate = new int[20];
		AssortedMethods.printIntArray(array);
		for (int i = 0; i < 20; i++) {
			validate[array[i]]++;
		}
		mergeSort(array, 0, array.length - 1);
		for (int i = 0; i < 20; i++) {
			validate[array[i]]--;
		}		
		AssortedMethods.printIntArray(array);
		for (int i = 0; i < 20; i++) {
			if (validate[i] != 0 || (i < 19 && array[i] > array[i+1])) {
				System.out.println("ERROR");
			}
		}		
	}
	
	
}