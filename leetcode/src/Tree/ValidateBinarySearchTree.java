package Tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 Assume a BST is defined as follows:
 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 OJ's Binary Tree Serialization:
 The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 Here's an example:
 1
 / \
 2   3
 /
 4
 \
 5
 The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

 * @author heguangliu
 *
 */
import java.util.*;

public class ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		TreeNode pre = null;
		while(!stack.isEmpty()){
			cur = stack.pop();
			if(pre!=null && pre.val >= cur.val) return false;
			pre = cur;
			cur = cur.right;
			while(cur!=null){
				stack.push(cur);
				cur = cur.left;
			}
		}
		return true;
	}
	
	
}