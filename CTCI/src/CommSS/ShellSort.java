package CommSS;
import java.util.*;
import CtCILibrary.*;

//Worst case time complexity depends on the gap sequence. 
//In the worst case its O(N^2). If the gap sequence is  
//based on Knuth formula (3^k-1) then it is O(N^3/2);
//Space Complexity: O(1)

public class ShellSort extends AbstractSort{
	public void sort(int[] array){
		int gap =1;
		int length = array.length;
		while(gap<length/3)
			gap = 3* gap+1;
		
		while(gap>0){
			for(int i=gap; i < length; i++){
				int temp = array[i];
				int j= i;
				for(; j>=gap && array[j-gap]>temp;j-=gap)
					array[j]=array[j-gap];
			}
			gap=(gap-1)/3;
		}
	}
}