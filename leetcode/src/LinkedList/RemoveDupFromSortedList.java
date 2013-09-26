package LinkedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once. For example, Given 1->1->2, return 1->2. Given
 * 1->1->2->3->3, return 1->2->3
 * 
 * @author heguangliu
 * 
 */
public class RemoveDupFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return head;
		ListNode last = head, curr = head.next;
		while (curr != null) {
			if (curr.val != last.val) {
				last.next = curr;
				last = curr;
				curr = curr.next;
			} else {
				curr = curr.next;
			}
		}
		last.next = curr;
		return head;
	}
}