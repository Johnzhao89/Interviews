package CommDS;
/**
 * 
 * @author heguangliu
 * better with a shift method
 */
public class Queue_Array{
	private int size;
	private int[] queue;
	
	private int front;
	private int back;
	
	public Queue_Array(int s){
		size =s;
		queue = new int[s];
		front =0;
		back =-1;
	}
	
	public boolean isFull(){
		return (back == size-1);
	}
	
	public boolean isEmpty(){
		return back == front-1;
	}
	
	public void enqueue(int n){
		if(!isFull()){
			queue[++back] =n;
		}
	}
	public int dequeue(){
		if(!isEmpty()){
			return queue[front++];
		}else
			return -1;
	}
	
	public int peek(){
		return queue[front];
	}
}