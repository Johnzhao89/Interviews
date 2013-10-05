package Tree;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.
 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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

public class RecoveryBinarySearchTree {
	// stack one
	public void recoverTreeStack(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeNode cur = root, pre = null, first = null, second = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (pre != null && cur.val < pre.val) {
				if (first == null) {
					first = pre;
					second = cur;
				} else {
					second = cur;
					break;
				}
			}
			pre = cur;
			cur = cur.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
		swap(first, second);
	}

	// recursion
	public void recoverTree(TreeNode root) {
		TreeNode[] nodes = new TreeNode[2];
		inorder(root, nodes, null);
		swap(nodes[0], nodes[1]);
	}

	// in order traversal and return the last visited node in the traversal
	private TreeNode inorder(TreeNode root, TreeNode[] nodes, TreeNode pre){
		if(root == null) return pre;
		TreeNode last = inorder(root.left, nodes, pre);
		if(last!=null && root.val < last.val){
			nodes[1] = root;// the smaller one in second pair
			if(nodes[0]== null){
				nodes[0] = last;// the larger on ein the first pair
			}else{
				return root;
			}
		}
		return inorder(root.right, nodes, root);
	}
	
	public void recoverMorris(TreeNode root){
		TreeNode pre = null, cur = root, n1= null, n2 = null;
		while(cur!=null){
			if(cur.left==null){
				if(pre!=null && pre.val > cur.val){
					n2 = cur;
					if(n1==null) n1 = pre;	
				}
				pre = cur;
				cur = cur.right;
			}else{
				TreeNode p = cur.left;
				while(p.right!=null && p.right!=cur){
					p = p.right;
				}
				if(p.right == null){
					p.right = cur;
					cur = cur.left;
				}else{
					p.right = null;
					if(pre.val > cur.val){
						n2 = cur;
						if(n1 == null) n1= pre;
					}
					pre = cur;
					cur = cur.right;
				}
			}
		}
		swap(n1, n2);
	}
	
	
	private void swap(TreeNode a, TreeNode b) {
		if (a == null || b == null)
			return;
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}

}