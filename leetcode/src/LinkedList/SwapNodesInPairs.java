package LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author heguangliu
 *
 */
public class SwapNodesInPairs{
	public static ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        	return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        int pos =1;
        while(curr!=null){
        	if(pos == 2){
        		pos =1;
        		prev = swap(prev, curr);
        		curr = prev.next;
        	}else{
        		curr= curr.next;
        		pos++;
        	}
        }
        return dummy.next;
    }
	public static ListNode swap(ListNode prev, ListNode tail){
		if(prev ==null || tail == null|| prev == tail)
			return tail;
		ListNode curr = prev.next;
		while(prev.next!=tail){
			ListNode nt = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = nt;
		}
		return curr;
	}
	
	public static void main(String[] args){
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		System.out.println(swapPairs(l));
	}
}