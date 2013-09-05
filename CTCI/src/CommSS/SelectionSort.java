package CommSS;

/**
 * find the smallest value in A, put in A[0], find the second smallest value in A
 * use an outer loop from 0 - N-1 , loop index teels which position o fill next step
 * each time around, use a nested lopp to find the smallest value, swap that value with a[k]
 * O(N2).
 * @author heguangliu
 */
public class SelectionSort extends AbstractSort{
	
	public void sort(int[] array) {
		int minIndex;
		for(int i=0; i<array.length; i++){
			minIndex=i;
			for(int j=i+1;j<array.length; j++){
				if(array[j]<array[minIndex])
					minIndex=j;
			}
			swap(array,i,minIndex);
		}
	}
}