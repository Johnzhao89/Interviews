package Tree;

/**
 * Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the 
root node down to the farthest leaf node.
 * @author heguangliu
 *
 */
public class MaxDepthOfBinaryTree{
	public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
        	return 0;
        int left=0, right =0;
        if(root.left!=null){
        	left=maxDepth(root.left);
        }
        if(root.right==null) return left+1;
        if(root.right!=null){
        	right=maxDepth(root.right);
        }
        return Math.max(left+1, right+1);
    }
}