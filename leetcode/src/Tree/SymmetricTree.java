package Tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
public class SymmetricTree{
	//O(n) time, O(n) space
	public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return (root==null) || isSymmetric(root.left, root.right);
    }
	
	public boolean isSymmetric2(TreeNode left, TreeNode right){
		if(left == null && right == null) return true;
		if(left == null || right == null || left.val!=right.val) return false;
		return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right){
		if(left == null && right == null) return true;
		if(left == null || right == null || left.val!= right.val) return false;
		Queue<TreeNode> lque = new ArrayDeque<TreeNode>();
		Queue<TreeNode> rque = new ArrayDeque<TreeNode>();
		lque.add(left); rque.add(right);
		while(!lque.isEmpty() && !rque.isEmpty()){
			TreeNode l = lque.remove();
			TreeNode r = rque.remove();
			if(l.left !=null && r.right!=null && l.left.val == r.left.val){
				lque.add(l.left); rque.add(r.right);
			}else if(!(l.left == null && r.right == null)){
				return false;
			}
			if(l.right != null && r.left!=null && l.right.val == r.left.val){
				lque.add(l.right); rque.add(r.left);
			}else if(!(l.right!=null && r.left!=null)){
				return false;
			}
		}
		return (lque.isEmpty() && rque.isEmpty());
	}
}