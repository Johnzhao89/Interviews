package CH2;
import CtCILibrary.*;
/**
 * 
 * @author heguangliu
 *
 */

public class Question4{
	public static LinkedListNode partition0(LinkedListNode node, int x){
		if(node ==null)
			return null;
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while(node!=null){
			LinkedListNode newNode= new LinkedListNode(node.data,null,null);// be cautious
			if(node.data<x){
				if(beforeStart==null){
					beforeStart = newNode;
					beforeEnd = newNode;
				}else{
					beforeEnd.next=newNode;
					beforeEnd=newNode;
				}
			}else{
				if(afterStart== null){
					afterStart = newNode;
					afterEnd = newNode;
				}else{
					afterEnd.next=newNode;
					afterEnd = newNode;
				}
			}
			node =node.next;
		}
		if(beforeStart ==null)
			return afterStart;
		beforeEnd.next=afterStart;
		return beforeStart;
	}
	
	
	public static LinkedListNode partition1(LinkedListNode node, int x){
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		
		while(node !=null){
			LinkedListNode next= node.next;
			if(node.data<x){
				node.next = beforeStart;
				beforeStart = node;
			}else{
				node.next = afterStart;
				afterStart = node;
			}
			node=next;
		}
		if(beforeStart == null){
			return afterStart;
		}
		LinkedListNode head = beforeStart;
		while(beforeStart.next!=null){
			beforeStart.next = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}
	
	public static void main(String[] args){
		int[] vals = {1, 3, 7, 5, 2, 9, 4};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		LinkedListNode h = partition0(head, 5);
		System.out.println(h.printForward());
		
		LinkedListNode h1=partition1(head,5);
		System.out.println(h1.printForward());
	}
}