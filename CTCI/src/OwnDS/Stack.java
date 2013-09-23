package OwnDS;

public class Stack{
	
	private int size;
	private int[] stack;
	private int top;
	
	public Stack(int s){
		size = s;
		stack = new int[size];
		top = -1;
	}
	
	public boolean isFull(){
		return top == size -1;
	}
	
	public boolean isEmpty(){
		return top ==-1;
	}
	
	public void push(int n){
		if(!isFull()){
			stack[++top] = n;
		}else{
			System.out.println("Stack full");
		}
	}
	
	public int pop(){
		if(!isEmpty()){
			return stack[top--];
		}else{
			return -1;
		}
	}
	
	public int peek(){
		return stack[top];
	}
}
