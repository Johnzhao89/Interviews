package Array;

/**
 * Given inorder and preorder traversal of a tree, construct the binary tree.
 * @author heguangliu
 *
 */
import java.util.*;

public class ConstructBTII {
	// root left right left root right
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || preorder.length != inorder.length)
			return null;
		return build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	// root left right  left root right
	public TreeNode build(int[] pre, int start1, int end1, int[] in,
			int start2, int end2) {
		if (start1 > end1 || start2 > end2)
			return null;
		int val = pre[start1];
		TreeNode cur = new TreeNode(val);
		int k = start2;
		for (; k <= end2; k++)
			if (in[k] == val)
				break;
		cur.left = build(pre, start1 + 1, start1 + k - start2, in, start2,k - 1);
		cur.right = build(pre, start1 + k - start2 + 1, end1, in, k + 1, end2);
		return cur;
	}
}