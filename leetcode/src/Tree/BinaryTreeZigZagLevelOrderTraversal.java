package Tree;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * @author heguangliu
 *
 */
import java.util.*;
public class BinaryTreeZigZagLevelOrderTraversal{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return result;
        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean oddLevel = false;
        current.push(root);
        while(!current.isEmpty()){
        	TreeNode curr = current.pop();
        	res.add(curr.val);
        	if(oddLevel){
        		if(curr.right!=null) next.push(curr.right);
        		if(curr.left!=null) next.push(curr.left);
        	}else{
        		if(curr.left!=null) next.push(curr.left);
        		if(curr.right!=null) next.push(curr.right);		
        	}
        	if(current.isEmpty()){
        		result.add(res);
        		res = new ArrayList<Integer>();
        		current.addAll(next);
        		next.clear();
        		oddLevel = !oddLevel;
        	}
        }
        return result;
    }
}