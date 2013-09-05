package CommSS;

import java.util.*;

public class CountingSort extends AbstractSort{
	
	public void sort(int array[]){
		int[] counts= new int[array.length+1];
		for(int i=0; i<array.length; i++){
			counts[array[i]]++;
		}
		
		int total =0;
		for(int i=0; i<=array.length;i++){
			int count = counts[i];
			counts[i]=total;
			total+= count;
		}
		int[] sortedValues = new int[array.length];
		for(int i=0; i<array.length;i++){
			sortedValues[counts[array[i]]]=array[i];
			counts[array[i]]++;
		}
		array=sortedValues.clone();
	}
}
