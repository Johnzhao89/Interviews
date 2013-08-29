package CH2;
import java.util.*;
import CtCILibrary.*;
/**
 * 
 * @author heguangliu
 *
 */

public class Question1{
	class Node{
		int data;
		Node next=null;
		public Node(int data){
			this.data= data;
		}
	}
	
	//Set
	public static void deleteDup0(LinkedListNode n){
		if(n == null)
			return;
		
		Set<Integer> set = new HashSet<Integer>();
		LinkedListNode prev=n;
		while(n!=null){
			if(set.contains(n.data)){
				prev.next=n.next;
				n=n.next;
			}else{
				set.add(n.data);
				prev=n;
				n=n.next;
			}
		}
	}	
	
	//no buffer allowed, small code, but be cautious
	public static void deleteDup1(LinkedListNode n){
		if( n == null)
			return;
		
		LinkedListNode i=n;
		while(i!=null){
			LinkedListNode j= i;
			while(j.next!= null){
				if(j.next.data==i.data){
					j.next=j.next.next;
				}else{
					j=j.next;
				}
			}
			i=i.next;
		}
	}
	
	public static void main(String[] args){
		    LinkedListNode first =AssortedMethods.randomLinkedList(20, 0, 10);
			LinkedListNode head = first;
			System.out.println("original: "+head.printForward());
			LinkedListNode clone = head.clone();
			deleteDup0(head);
			deleteDup1(clone);
			System.out.println("deletedup0: "+head.printForward());
			System.out.println("deletedup1: "+clone.printForward());
	}
}