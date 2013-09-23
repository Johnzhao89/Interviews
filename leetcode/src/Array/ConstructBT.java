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
        if(inorder.length == 0)
        	return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int i = inorder.length -1;
        for (; inorder[i] != root.val; i--)
            ;
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
        root.left = buildTree(Arrays.copyOfRange(inorder, 0,i), Arrays.copyOfRange(postorder, 0,i));
        return root;
    }
}