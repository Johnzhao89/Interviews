package Tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values 
 * along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author heguangliu
 *
 */

public class PathSum{
	public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
        	return false;
        return hasPathSum(root, root.val,sum);
    }
	
	public boolean hasPathSum(TreeNode curr,int path ,int sum){
		if(curr.left==null && curr.right == null)
			return path == sum;
		boolean PathL=false,  PathR=false;
		if(curr.left!=null )PathL= hasPathSum(curr.left, path+curr.left.val,sum);
		if(curr.right!=null)PathR = hasPathSum(curr.right, path+curr.right.val, sum);
		return PathL || PathR;
	}
}