package Tree;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author heguangliu
 *
 */
import java.util.*;
public class PathSumII{
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return result;
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        pathSum(root, sum,root.val, path, result);
        return result;
    }
	private void pathSum(TreeNode root, int sum, int cost, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
		if(root == null) return;
		if(root.left==null && root.right == null){
			if(cost == sum) result.add(path);
			return; 
		}
		if(root.left!=null){
			ArrayList<Integer> pathL = new ArrayList<Integer>(path);
			pathL.add(root.left.val);
			pathSum(root.left, sum, cost+root.left.val, pathL, result);
		}
		if(root.right!=null){
			ArrayList<Integer> pathR = new ArrayList<Integer>(path);
			pathR.add(root.right.val);
			pathSum(root.right, sum, cost+root.right.val, pathR, result);
		}
	}
}