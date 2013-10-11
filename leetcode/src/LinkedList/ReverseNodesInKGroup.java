package LinkedList;
/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
 * @author heguangliu
 *
 */
public class ReverseNodesInKGroup{
	public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        	return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        int pos =1;
        while(curr!=null){
        	if(pos == k){
        		pos = 0;
        		prev = reverse(prev, curr);
        		curr = prev.next;
        	}else{
        		curr = curr.next;
        	}
        	pos++;
        }
        return dummy.next;
    }
	// continually insert
	private ListNode reverse(ListNode prev, ListNode tail){
		if(prev == null || tail ==null)
			return tail;
		ListNode curr = prev.next;
		while(prev.next!= tail){
			ListNode nt = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = nt;
		}
		return curr;
	}
	
	
	public ListNode Reverse(ListNode list)
	{
	    if (list == null) return null; // first question
	    if (list.next == null) return list; // second question
	    // third question - in Lisp this is easy, but we don't have cons
	    // so we grab the second element (which will be the last after we reverse it)
	    ListNode secondElem = list.next;
	    // bug fix - need to unlink list from the rest or you will get a cycle
	    list.next = null;
	    // then we reverse everything from the second element on
	    ListNode reverseRest = Reverse(secondElem);
	    // then we join the two lists
	    secondElem.next = list;
	    return reverseRest;
	}
}