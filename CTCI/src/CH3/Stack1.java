package CH3;

public class Stack1{
	class Node{
		Object data;
		Node next;
		public Node(Object data){
			this.data = data;
			next =null;
		}
	}
	Node top;
	Object pop(){
		if(top!=null){
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(Object item){
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Object peek(){
		return top.data;
	}
}