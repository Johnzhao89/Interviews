package CH2;

import java.util.*;
import CH2.Result;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 * 
 */

public class Question7 {
	public static boolean isPalindrome0(LinkedListNode head) {
		LinkedListNode fast = head, slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next == null)
			slow = slow.next;

		while (slow != null) {
			int value = stack.pop();
			System.out.println(slow.data + " " + value);
			if (value != slow.data)
				return false;
		}
		return true;
	}


	public static Result isPalindromeRecurse(LinkedListNode head, int length) {
		if (head == null || length == 0) {
			return new Result();
		} else if (length == 1) {
			return new Result(head.next, true);
		} else if (length == 2) {
			return new Result(head.next.next, head.data == head.next.data);
		}
		Result res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null) {
			return res; 
		} else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}
	
	public static boolean isPalindrome(LinkedListNode head){
		int size =0;
		LinkedListNode n = head;
		while(n!=null){
			size++;
			n = n.next;
		}
		Result p = isPalindromeRecurse(head, size);
		return p.result;
	}

	public static void main(String[] args) {
		int length = 10;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		Question7 q = new Question7();
		System.out.println(q.isPalindrome(head));
	}
}