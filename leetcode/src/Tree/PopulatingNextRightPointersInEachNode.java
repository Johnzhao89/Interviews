package Tree;

/**
 * Given a binary tree struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode
 * *right; TreeLinkNode *next; } Populate each next pointer to point to its next
 * right node. If there is no next right node, the next pointer should be set to
 * NULL. Initially, all next pointers are set to NULL. Note: You may only use
 * constant extra space. You may assume that it is a perfect binary tree (ie,
 * all leaves are at the same level, and every parent has two children). For
 * example, Given the following perfect binary tree, 1 / \ 2 3 / \ / \ 4 5 6 7
 * After calling your function, the tree should look like: 1 -> NULL / \ 2 -> 3
 * -> NULL / \ / \ 4->5->6->7 -> NULL
 * 
 * @author heguangliu
 * 
 */

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeLinkNode first = root;
		while (first != null) {
			TreeLinkNode cur = first;
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			first = first.left;
		}
	}
}