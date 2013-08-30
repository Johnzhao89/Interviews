package CH2;

import CtCILibrary.LinkedListNode;

class Result{
	public LinkedListNode node;
	public int count;
	public boolean result;
	public Result(LinkedListNode n, int c){
		node = n;
		count =c;
	}
	public Result(LinkedListNode n, boolean result){
		node = n;
		this.result = result;
	}
	public Result(){
		node=null;
		this.result=true;
	}
	
}
