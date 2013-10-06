package Tree;

/**
 * Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3
Return 6.
 * @author heguangliu
 *
 */
public class BinaryTreeMaxPathSum{
	private class Data{
		int path =0;// need include this code
		int sum = Integer.MIN_VALUE;//not need to include this code
	}
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Data data = maxSubPath(root);
        return data.sum;
    }
	private Data maxSubPath(TreeNode root){
		Data data = new Data();
		if(root == null) return data;
		Data l = maxSubPath(root.left);
		Data r = maxSubPath(root.right);
		data.path = Math.max(0, Math.max(l.path, r.path)+root.val);
		data.sum = Math.max(Math.max(l.sum, r.sum), l.path+root.val+r.path);
		return data;
	}
}