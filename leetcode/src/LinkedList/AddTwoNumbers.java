package LinkedList;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4 ->
 * 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author heguangliu
 * 
 */
public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null || l2==null)
			return l1== null? l2: l1;
		int carry =0;
		ListNode iter1 = l1, iter2 = l2, head = null, prev = null, curr=null;
		while(iter1!=null || iter2!=null || carry !=0){
			int num1 = iter1==null ? 0: iter1.val;
			int num2 = iter2==null ? 0: iter2.val;
			int sum = num1+ num2 + carry;
			carry = sum/10;
			curr =new ListNode(sum%= 10);
			
			if(head == null){
				head = curr;
				prev = curr;
			}else{
				prev.next = curr;
				prev = curr;
			}
			iter1 = iter1==null? null: iter1.next;
			iter2 = iter2==null? null: iter2.next;
		}
		return head;
	}
	
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		l1.next= new ListNode(8);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(1);
		System.out.println(addTwoNumbers(l1,l2));
	}
}
