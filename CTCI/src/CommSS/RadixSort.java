package CommSS;
import java.util.*;
import CtCILibrary.*;


public class RadixSort extends AbstractSort{
	public void sort(int[] array){
		radixSort(array, array.length,5);
	}
	// still kinda confused
	public void radixSort(int a[], int rad, int max){
		
		int tmp[][] = new int[a.length][10];
		
		for(int i=0; i< max; i++){
			
			int c =0;
			//fill with 0
			for(int j = 0; j<a.length; j++)
				for(int k =0; k< rad; k++)
					tmp[j][k]=0;
			
			//put digit into array
			for(int k=0; k< a.length; k++){
				int d = (int)((a[k]/Math.pow(10,i))%10);
				tmp[k][d]=a[k];
			}
			
			for(int j =0; j< rad; j++){
				for(int k=0; k< a.length ;k++)
					if(tmp[k][j]!=0)
						a[c++]=tmp[k][j];
			}
		}
		System.out.println(a);
	}
}