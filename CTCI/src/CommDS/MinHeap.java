package CommDS;
import java.util.*;
/**
 * 
 * @author heguangliu
 *
 */
public class MinHeap{
	private int maxSize;
	private int current;
	private int[] heap;
	
	public MinHeap(int max){
		maxSize = max;
		heap = new int[maxSize + 1];// min is heap[1]
		current =0;
	}
	
	public void insert(int value){
		if(current == maxSize){
			throw new RuntimeException("Heap is full.");
		}
		heap[++current] = value;
		shiftUp(current);
	}
	
	public boolean isEmpty(){
		return current ==0;
	}
	
	public int min(){
		if(isEmpty())
			throw new RuntimeException();
		return heap[1];
	}
	
	public int removeMin(){
		if(isEmpty())
			throw new RuntimeException();
		int min = heap[1];
		swap(1, current);
		current --;
		if(current!=0)
			shiftDown(1);
		return min;
	}
	
	private void shiftUp(int k){
		while(k > 1 && heap[k/2] > heap[k]){
			swap( k / 2, k);
			k = k / 2;
		}
	}
	
	private void shiftDown(int k){
		while( 2*k <= current){
			int i = 2*k;
			int j = 2*k + 1;
			if(heap[k] < Math.min(heap[i], heap[j]))
				break;
			if(heap[i] > heap[j]){
				swap(k , j);
				k = j;
			}else{
				swap(k , i);
				k = i;
			}
		}
	}
	
	private void swap(int i, int j){
		int tmp =heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	private boolean isMinHeap(){
		return isMinHeap(1);
	}
	// is subtree of array[] rooted at k a min heap
	private boolean isMinHeap(int k){
		if(k > current)
			return true;
		int left = 2*k;
		int right = 2*k +1;
		if(left <= current && heap[k]>heap[left]) return false;
		if(right<= current && heap[k]>heap[right]) return false;
		return isMinHeap(left) && isMinHeap(right);
	}
	
	public void printHeap(){
		System.out.println("heap: ");
		for(int i = 1; i <= current; i++){
			System.out.println(heap[i]+" ");
		}
		System.out.println();
	}
}