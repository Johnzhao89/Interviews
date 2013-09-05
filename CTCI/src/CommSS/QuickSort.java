package CommSS;

//choose a ivot value, partition the array(put all value less than the pivot in the left)
//Recursively, sort the values less than the pivot.
//Recursively, sort the values greater than the pivot.
//less extra storage compare to merge sort, but worse worest case O(N^2)
public class QuickSort extends AbstractSort{
	public void sort(int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private void quickSort(int[] array, int start, int end){
		if(start<end){
			int mid= partition(array, start, end);
			quickSort(array, start, mid-1);
			quickSort(array, mid, end);
		}
	}
	
	private int partition(int[] array, int start, int end){
		int pivot = array[(start+end)/2];
		while(start<=end){
			while(array[start]<pivot){
				start++;
			}
			while(array[end]>pivot){
				end--;
			}
			if(start<=end){
				swap(array, start, end);
				start++;
				end--;
			}
		}
		return start;
	}
	
}