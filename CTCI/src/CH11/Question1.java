package CH11;
import java.util.*;
import CtCILibrary.*;

public class Question1{
	public static void merge(int a[], int b[], int lastA, int lastB){
		int indexMerged = lastA +lastB -1;
		int indexA = lastA -1;
		int indexB = lastB -1;
		
		while(indexA >= 0 && indexB >=0){
			if(a[indexA]>b[indexB]){
				a[indexMerged]= a[indexA];
				indexMerged--;
				indexA--;
			}else{
				a[indexMerged]=a[indexB];
				indexMerged--;
				indexB--;
			}
		}
		while(indexB>=0){
			a[indexMerged]=b[indexB];
			indexMerged--;
			indexB--;
		}
	}
	
	public static void main(String[] args){
		int[] a = {1, 3, 4, 5, 6, 8, 10, 0, 0, 0, 0, 0};
		int[] b = {4, 7, 9, 10, 12};
		merge(a, b, 7, 5);
		System.out.println(AssortedMethods.arrayToString(a));
	}
}
