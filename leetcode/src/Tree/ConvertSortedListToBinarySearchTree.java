package Tree;


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

public class ConvertSortedListToBinarySearchTree {
	
	public static TreeNode sortedListToBST(ListNode head) {
		int len =0;
		ListNode cur = head;
		while(cur!=null){
			cur = cur.next;
			len++;
		}
		return listToBST(head, 0, len-1);
	}
	private static TreeNode listToBST(ListNode head, int low, int high){
		if(low > high) return null;
		int mid = low+(high - low)/2;
		TreeNode left = listToBST(head, low, mid-1);
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		if(head.next != null){
			head.val = head.next.val;
			head.next = head.next.next;
			root.right = listToBST(head, mid+1, high);
		}
		return root;
	}
	
	public static void main(String[] args){
		ListNode newNode = new ListNode(0);
		newNode.next = new ListNode(1);
		newNode.next.next = new ListNode(2);
		newNode.next.next.next = new ListNode(3);
		newNode.next.next.next.next = new ListNode(4);
		System.out.println(newNode);
		sortedListToBST(newNode);
		System.out.println(newNode);
	}
}