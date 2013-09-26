package LinkedList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author heguangliu
 *
 */
import java.util.*;
public class MergeKSortedLists{
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists == null || lists.isEmpty())
        	return null;
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
			public int compare(ListNode arg0, ListNode arg1) {
				return arg0.val== arg1.val? 0: arg0.val < arg1.val? -1: 1;
			}
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
        ListNode head = null;
        ListNode curr = null;
        for(int i=0; i< lists.size(); i++){
        	ListNode node = lists.get(i);
        	if(node!=null) heap.add(lists.get(i));
        }
        while(!heap.isEmpty()){
        	if(head == null){
        		head = heap.poll();
        		curr = head;
        		if(curr.next != null)
        			heap.add(curr.next);
        	}else{
        		ListNode newNode = heap.poll();
        		curr.next = newNode;
        		curr = newNode;
        		if(curr.next !=null)
        			heap.add(curr.next);
        	}
        }
        return head;
    }

}