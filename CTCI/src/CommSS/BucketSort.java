package CommSS;

import java.util.*;

public class BucketSort{
	public void sort(int array[]){
		
	}
	
	public static void bucketSort(int[] array, int maxVal){
		int[] bucket = new int[maxVal+1];
		for(int i=0; i<bucket.length; i++){
			bucket[i]=0;
		}
		for(int i=0; i<array.length;i++){
			bucket[array[i]]++;
		}
		System.out.println(bucket);
		int outPos =0;
		for(int i=0; i<bucket.length; i++){
			for(int j=0; j<bucket[i]; j++){
				array[outPos++]=i;
			}
		}
	}
}
