package CH4;

import java.util.*;
import CtCILibrary.*;

public class Question6 {
	// left root right
	public static TreeNode inorderSucc(TreeNode n) {
		if (n == null)
			return null;
		if (n.parent == null || n.right != null)// be cautious here
			return leftMostChild(n.right);
		else {//find the last parent whose left child is current root 
			TreeNode q = n;
			TreeNode x = q.parent;
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}

	public static TreeNode leftMostChild(TreeNode n) {
		if (n == null)
			return null;
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
}