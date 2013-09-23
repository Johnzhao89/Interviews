package OwnDS;

public class Queue{
	private int size;
	private int[] queue;
	
	private int front;
	private int back;
	
	public Queue(int s){
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