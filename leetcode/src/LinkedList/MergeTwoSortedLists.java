package LinkedList;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author heguangliu
 * 
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public String toString(){
		ListNode curr = this;
		String result="";
		while(curr!=null){
			result +=(curr.val+"->");
			curr= curr.next;
		}
		return result;
	}
}

public class MergeTwoSortedLists {
	// reorganize better than insert
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode head = null, pre = null, node=null;
		while (l1 != null || l2 != null) {
			node = getMin(l1, l2);
			if (pre == null)
				head = node;
			else pre.next = node;
			pre = node;
			if (node == l1)
				l1 = l1.next;
			else
				l2 = l2.next;
		}
		return head;
	}

	public ListNode getMin(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else if (l1.val < l2.val)
			return l1;
		else
			return l2;
	}
	
}