package CH2;
import CtCILibrary.*;
/**
 * 
 * @author heguangliu
 *
 */

public class Question2{
	
	public static int nthToLastR1(LinkedListNode head, int n){
		if(n ==0||head==null){
			return 0;
		}
		int k=nthToLastR1(head.next,n)+1;
		if (k == n) {
			System.out.println(n + "th to last node is " + head.data);
		}
		return k;
	}
	
	public static LinkedListNode nthToLastR2(LinkedListNode head, int n, IntWrapper i){
		if(head == null)
			return null;
		LinkedListNode node= nthToLastR2(head.next, n, i);
		i.value=i.value+1;
		if(i.value ==n)
			return head;
		return node;
	}
	
	
	public static Result nthToLastR3Helper(LinkedListNode head, int k){
		if(head == null){
			return new Result(null, 0);
		}
		Result res= nthToLastR3Helper(head.next,k);
		if(res.node == null){
			res.count++;
			if(res.count == k){
				res.node = head;
			}
		}
		return res;
	}
	
	public static LinkedListNode nthToLastR3(LinkedListNode head, int k){
		Result res= nthToLastR3Helper(head, k);
		if(res!=null){
			return res.node;
		}
		return null;
	}
	
	public static LinkedListNode nthToLast(LinkedListNode head, int n){
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		for(int i=0; i<n-1;i++){
			if(p2==null){
				return null;
			}
			p2=p2.next;
		}
		if(p2==null){
			return null;
		}
		while(p2.next!=null){
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args){
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth =3;
		IntWrapper wr = new IntWrapper();
		LinkedListNode n0= nthToLastR2(head,nth,wr);
		LinkedListNode n = nthToLastR3(head, nth);
		nthToLastR1(head, nth);
		if (n != null) {
			System.out.println(nth + "th to last node is " + n0.data);
			System.out.println(nth + "th to last node is " + n.data);
		} else {
			System.out.println("Null.  n is out of bounds.");
		}
	}
	/*
	//recursive 1
	class Wrapper{
		public LinkedListNode current;
		public int count=0;
		Wrapper(LinkedListNode current, int count){
			this.current = current;
			this.count = count;
		}
		Wrapper next(){
			return new Wrapper(current.next,count+1);
		}
	}
	
	class IntWrapper{
		public int count=0;
	}
	
	Wrapper nthToLast0(int k, Wrapper w){
		if(w.current == null)
			return null;
		Wrapper wrap= nthToLast0(k, w.next());
		if(w.count==k-1)
			return new Wrapper(w.current,k);
		return wrap;
	}
	//recursive 2
	
	public static LinkedListNode nthToLast1(LinkedListNode head, int k, IntWrapper i){
		if(head==null)
			return null;
		LinkedListNode node=nthToLast1(head.next,k,i);
		i.count++;
		if(i.count==k)
			return head;
		return node;
	}
	
	
	public static void main(String[] args){
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		
		System.out.println("Test 1:");
		Question2.IntWrapper i= new Question2.IntWrapper();
		LinkedListNode node=nthToLast1(head,3, new IntWrapper());
		
		System.out.println("Test 0:");
		
	}
	*/
	
}