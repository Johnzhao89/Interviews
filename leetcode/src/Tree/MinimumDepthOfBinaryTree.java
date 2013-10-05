package Tree;

/**
 * Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node 
down to the nearest leaf node.
 * @author heguangliu
 *
 */
import java.util.*;
public class MinimumDepthOfBinaryTree{
	
	public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
        	return 0;
        int depth = 1;
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        curr.offer(root);
        while(!curr.isEmpty()){
        	TreeNode cur = curr.poll();
        	if(cur.left== null && cur.right == null)
        		return depth;
        	if(cur.left!=null) next.offer(cur.left);
        	if(cur.right!=null) next.offer(cur.right);
        	if(curr.isEmpty()){
        		curr.addAll(next);
        		next.clear();
        		depth++;
        	}
        }
        return depth;
    }
	
	
}