package CommSS;

/**
 * put the first 2 items in correct relative orser
 * insert the 3rd item in the correct place relative to the first 3
 * could use binary search to speed up, but not complexity
 */

public class InsertionSort extends AbstractSort{
	public void sort(int[] array) {
		for(int i=1; i<array.length; i++){
			int temp= array[i];
			int hole = i;
			while((hole>0)&& (array[hole-1]>temp)){
				array[hole]= array[hole-1];
			}
			array[hole]=temp;
		}
	}
}
