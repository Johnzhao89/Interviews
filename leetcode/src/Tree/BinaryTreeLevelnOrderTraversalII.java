package Tree;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree {3,9,20,#,#,15,7},
 * @author heguangliu
 *
 */
import java.util.*;
public class BinaryTreeLevelnOrderTraversalII{
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return result;
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        current.offer(root);
        while(!current.isEmpty()){
        	TreeNode curr = current.poll();
        	res.add(curr.val);
        	if(curr.left!=null){
        		next.offer(curr.left);
        	}
        	if(curr.right !=null){
        		next.offer(curr.right);
        	}
        	if(current.isEmpty()){
        		result.add(res);
        		res = new ArrayList<Integer>();
        		current.addAll(next);
        		next.clear();
        	}
        }
        Collections.reverse(result);
        return result;
	}
}