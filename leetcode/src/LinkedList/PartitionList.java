package LinkedList;
/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * @author heguangliu
 *
 */
public class PartitionList{
	public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
        	return null;
        ListNode start1 = new ListNode(0);
        ListNode start2 = new ListNode(x);
        ListNode tail1=start1, tail2=start2;
        ListNode iter=head;
        while(iter!=null){
        	ListNode next = iter.next;
        	if(iter.val <x){
        		tail1.next = iter;
        		tail1 = iter;
        	}else{
        		tail2.next = iter;
        		tail2 = iter;
        		tail2.next =null;
        	}
        	iter = next;
        }
        tail1.next = start2.next;
        return start1.next;
    }
}