package CH3;

import java.util.Stack;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 *
 */
public class Question2{
	static class NodeWithMin{
		public int value;
		public int min;
		public NodeWithMin(int v, int min){
			value =v;
			this.min= min;
		}
	}
	
	
	static class StackWithMin0 extends java.util.Stack<NodeWithMin>{
		
		public void push(int value){
			int newMin= Math.min(value, min());
			super.push(new NodeWithMin(value,newMin));
		}
		
		public int min(){
			if(this.isEmpty()){
				return Integer.MAX_VALUE;
			}else{
				return peek().min;
			}
		}
	}
	
	static class StackWithMin1 extends java.util.Stack<Integer>{
		private Stack<Integer> minStack;
		public StackWithMin1(){
			super();
			minStack = new Stack<Integer>();
		}
		
		public void push(int value){
			if(value<=min()){
				minStack.push(value);
			}
			super.push(value);
		}
		
		public Integer pop(){
			int value = super.pop();
			if(value==min()){
				minStack.pop();
			}
			return value;
		}
		
		public int min(){
			if(minStack.isEmpty()){
				return Integer.MAX_VALUE;
			}else{
				return minStack.peek();
			}
		}
	}
	
	public static void main(String[] args){
		StackWithMin0 stack0 = new StackWithMin0();
		StackWithMin1 stack1 = new StackWithMin1();
		
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack0.push(value);
			stack1.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < 15; i++) {
			System.out.println("Popped " + stack0.pop().value + ", " + stack1.pop());
			System.out.println("New min is " + stack0.min() + ", " + stack1.min());
		}
	}
	
	
	
}