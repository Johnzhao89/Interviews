package Array;
/**
 * Given inorder and preorder traversal of a tree, construct the binary tree.
 * @author heguangliu
 *
 */
import java.util.*;
   
public class ConstructBTII{
	//root left right  left root right
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length == 0)
        	return null;
        TreeNode root = new TreeNode(preorder[0]);
        int indexInInorder=0;
        while(indexInInorder<inorder.length && inorder[indexInInorder] != preorder[0])
        	indexInInorder++;
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, indexInInorder+1), Arrays.copyOfRange(inorder, 0, indexInInorder));
        root.right = buildTree(Arrays.copyOfRange(preorder, indexInInorder+1, preorder.length),Arrays.copyOfRange(inorder, indexInInorder+1, preorder.length));
        return root;
    }
}