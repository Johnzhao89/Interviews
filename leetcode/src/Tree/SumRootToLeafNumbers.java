package Tree;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
 * @author heguangliu
 *
 */
public class SumRootToLeafNumbers{
	// typical DFS O(n) time, O(logn) space
	public static int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root == null) return 0;
        int[] sum = new int[1];
        sumNumbers(sum, 0,root);
        return sum[0];
    }
	public static void sumNumbers(int[] sum, int path, TreeNode root){
		if(root.left ==null && root.right == null ) sum[0]+= (path*10+root.val);
		if(root.left!=null){
			int pathL = path*10+root.val;
			sumNumbers(sum, pathL, root.left);
		}
		if(root.right!=null){
			int pathR = path*10 + root.val;
			sumNumbers(sum, pathR, root.right);
		}
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
	}
}