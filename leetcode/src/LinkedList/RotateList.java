package LinkedList;

/**
 * Given a list, rotate the list to the right by n places, where n is
 * non-negative. For example: Given 1->2->3->4->5->NULL and n = 2, return
 * 4->5->1->2->3->NULL.
 * 
 * @author heguangliu
 * 
 */
public class RotateList {
	public static ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len =0;
        ListNode curr = head;
        while(curr!=null){
        	len++;
        	curr= curr.next;
        }
        if(len == 0|| n % len == 0) return head;
        n = n % len;
        
        ListNode slow = head, fast= head;
        int pos =1;
        while(fast.next!=head){
        	if(n >0){
        		n--;
        	}else{
        		slow = slow.next;
        	}
        	fast = fast.next;
        	if(fast.next == null) fast.next = head;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
	}
	
	public static void main(String[] args){
		ListNode l = new ListNode(1);
		l.next = new  ListNode(2);
		//l.next.next = new ListNode(3);
		//l.next.next.next = new ListNode(4);
		//l.next.next.next.next = new ListNode(5);
		System.out.println(rotateRight(l, 1));
	}
}