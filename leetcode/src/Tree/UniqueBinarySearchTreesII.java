package Tree;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
For example,
Given n = 3, your program should return all 5 unique BST's shown below.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * @author heguangliu
 *
 */
public class UniqueBinarySearchTreesII{
	public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return genSubTrees(1,n);
    }
	
	//recursive
	private ArrayList<TreeNode> genSubTrees(int l, int r){
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		if(l > r){
			trees.add(null);
		}else{
			for(int i =l; i<= r; i++){
				ArrayList<TreeNode> lefts = genSubTrees(l, i-1);
				ArrayList<TreeNode> rights = genSubTrees(i+1, r);
				for(TreeNode left: lefts){
					for(TreeNode right: rights){
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						trees.add(root);
					}
				}
			}
		}
		return trees;
	}
}