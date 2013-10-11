package Array;
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * @author heguangliu
 *
 */
import java.util.*;
  
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class ConstructBT{
	//left root right  left right root Helper prefered
	public TreeNode buildTree(int[] inorder, int[] postorder) {
	    if(inorder == null || postorder == null) return null;
	    if(inorder.length == 0 || inorder.length != postorder.length) return null;
	    return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	public TreeNode build(int[] in, int start1, int end1, int[] post, int start2, int end2){
	    if(start1 > end1 || start2 > end2) return null;
	    int val = post[end2];
	    TreeNode cur = new TreeNode(val);
	    int k = start1;
	    for(; k <= end1; k++) 
	         if(val == in[k]) break;
	    cur.right = build(in, k + 1, end1, post, end2 - end1 + k, end2 - 1);
	    cur.left = build(in, start1, k - 1, post, start2, end2 - end1 + k - 1);
	    return cur;
	}
}