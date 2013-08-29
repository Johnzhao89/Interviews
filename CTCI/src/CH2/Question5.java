package CH2;
import java.util.*;
import CtCILibrary.*;

// buggy, need further debug
/**
 * 
 * @author heguangliu
 *
 */

public class Question5{
	
	private static LinkedListNode addLists0(LinkedListNode l1, LinkedListNode l2, int carry){
		if(l1==null && l2==null && carry==0){
			return null;
		}
		
		LinkedListNode result = new LinkedListNode(carry, null, null);
		int value = carry;
		if(l1!=null){
			value+=l1.data;
		}
		if(l2!=null){
			value+=l2.data;
		}
		result.data = value%10;
		if(l1!=null ||l2!=null||carry!=0){
			LinkedListNode more = addLists0(l1==null? null:l1.next,l2==null?null:l2.next,value>=10?1:0);
			result.setNext(more);
		}
		return result;
	}
	
	public static int linkedListToInt(LinkedListNode node){
		int value =0;
		if(node.next!=null){
			value = 10*linkedListToInt(node.next);
		}
		return value +node.data;
	}
	
	public static LinkedListNode addLists1(LinkedListNode l1, LinkedListNode l2){
		int len1=length(l1);
		int len2=length(l2);
		if(len1<len2){
			l1=padList(l1,len2-len1);
		}else{
			l2= padList(l2,len1-len2);
		}
		PartialSum sum =addListsHelper(l1, l2);
		if(sum.carry ==0){
			return sum.sum;
		}else{
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	//Utility
	public static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2){
		if(l1==null && l2==null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val= sum.carry+l1.data+l2.data;
		LinkedListNode full_result = insertBefore(sum.sum, val%10);
		sum.sum=full_result;
		sum.carry = val/10;
		return sum;
	}
	
	public static LinkedListNode padList(LinkedListNode l, int padding){
		LinkedListNode head=l;
		for(int i=0; i<padding; i++){
			LinkedListNode n = new LinkedListNode(0,null,null);
			head.prev = n;
			n.next=head;
			head =n;
		}
		return head;
	}
	
	private static int length(LinkedListNode l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}
	
	public static LinkedListNode insertBefore(LinkedListNode list, int data){
		LinkedListNode node= new LinkedListNode(data, null, null);
		if(list!=null){
			list.prev=node;
			node.next=list;
		}
		return node;
	}
	
	
	
	
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		//LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		//LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
		LinkedListNode list3 = addLists0(lA1, lB1, 0);
		LinkedListNode list4 = addLists1(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		int l4 = linkedListToInt(list4);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		//System.out.print(l1 + " + " + l2 + " = " + l4 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}
	
}