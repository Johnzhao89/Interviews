package LinkedList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 * @author heguangliu
 *
 */
//dummy(0)
public class RemoveNthNodeFromEndofList{
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(head == null|| n <= 0)
	        	return null;
	        ListNode fast = head, slow = head;
	        int i;
	        for(i=0; i< n && fast!=null; i++)
	        	fast = fast.next;
	        if( i== n && fast==null)// check special case
	        	return head.next;
	        else if(i!=n)// check special case
	        	return null;
	        while(fast.next!=null){
	        	fast = fast.next;
	        	slow = slow.next;
	        }
	        slow.next = slow.next==null? null:slow.next.next;
	        return head;
	    }
}