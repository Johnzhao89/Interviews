package LinkedList;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * @author heguangliu
 * 
 */
public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || m >= n || m < 1)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev = dummy, curr = head;
		int pos =1;
		while(pos < m && curr!=null){
			prev = curr;
			curr = curr.next;
			pos++;
		}
		
		while(pos< n && curr!=null){
			ListNode next = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = next;
			pos++;
		}
		return dummy.next;
	}
}
