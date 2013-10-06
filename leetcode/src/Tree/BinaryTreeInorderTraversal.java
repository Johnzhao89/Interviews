package Tree;

import java.util.*;

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		inorderMorris(root, result);
		return result;
	}

	private void inorderMorris(TreeNode root, ArrayList<Integer> values) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) { // set right to successor
					pre.right = cur;
					cur = cur.left;
				} else { // visit and revert the change
					pre.right = null;
					values.add(cur.val);
					cur = cur.right;
				}
			} else { // visit and move to successor
				values.add(cur.val);
				cur = cur.right;
			}
		}
	}
}