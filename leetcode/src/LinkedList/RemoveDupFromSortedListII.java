package LinkedList;
/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct 
 * numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * @author heguangliu
 *
 */
public class RemoveDupFromSortedListII{
	public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        	return head;
        ListNode dummy = new ListNode(0), last=head, curr=head.next, tail= dummy ;
        while(curr!=null){
        	if(curr.val!=last.val){
        		if(last.next==curr){
        			tail.next = last;
        			tail = last;
        			tail.next = null;
        		}
        		last = curr;
        		curr = curr.next;
        	}else{
        		curr = curr.next;
        	}
        }
        if(last.next == curr){
        	tail.next = last;
        	last.next = null;
        }
        return dummy.next;
    }
}