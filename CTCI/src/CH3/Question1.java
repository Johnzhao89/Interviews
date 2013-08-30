package CH3;


/**
 * 
 * @author heguangliu
 *
 */
public class Question1{
	public final static int STACK_SIZE =10;
	private static int[] buffer = new int[STACK_SIZE *3];
	
	static int[] stackPointer ={-1, -1,-1};
	
	static void push(int stackNum, int value) throws Exception{
		if(stackPointer[stackNum]+1>=STACK_SIZE){
			throw new Exception("Out of space");
		}
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)]=value;
	}
	
	static int pop(int stackNum) throws Exception{
		if(stackPointer[stackNum]==-1){
			throw new Exception("Trying to pop an empty stack.");
		}
		int value = buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)]=0;
		stackPointer[stackNum]--;
		return value;
	}
	
	static int peek(int stackNum)throws Exception{
		if(stackPointer[stackNum]==-1){
			throw new Exception("stack empty");
		}
		return buffer[absTopOfStack(stackNum)];
	}
	static boolean isEmpty(int stackNum){
		return stackPointer[stackNum]==-1;
	}
	static int absTopOfStack(int stackNum){
		return stackNum*STACK_SIZE +stackPointer[stackNum];
	}
	
	public static void main(String [] args) throws Exception  {
		push(2, 4);
		System.out.println("Peek 2: " + peek(2));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
	}
}