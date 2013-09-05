package CH4;
import java.util.*;
import CtCILibrary.*;

public class Question7{
	public static boolean covers(TreeNode root, TreeNode p){
		if(root == null) return false;
		if(root == p) return true;
		return covers(root.left,p)|| covers(root.right, p);
	}
	// assume p, q must in the tree
	public static TreeNode commonAncestorHelper0(TreeNode root,TreeNode p,TreeNode q){
		if(root == null)
			return null;
		boolean is_p_on_left = covers(root.left,p);
		boolean is_q_on_left = covers(root.left,q);
		if(is_p_on_left != is_q_on_left){
			return root;
		}
		TreeNode child_side = is_p_on_left? root.left: root.right;
		return commonAncestorHelper0(child_side,p,q);
	}
	
	public static TreeNode commonAncestor0(TreeNode root,TreeNode p,TreeNode q){
		if(!covers(root,p)||!covers(root,q))
			return null;
		return commonAncestor0(root, p,q);
	}
	
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor0(root, n3, n7);
		System.out.println(ancestor.data);
	}
	//the node itself and whether this node is actual a common ancestor
	static class Result{
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc){
			node = n;
			isAncestor = isAnc;
		}
	}
	// assume the root will cover both node p and q
	// pre-check one side will decrease complexity
	// check if common ancestor in left side and right side, if it is ,return it
	public static Result commonAncestorHelper1(TreeNode root, TreeNode p, TreeNode q ){
		if(root == null){
			return new Result(null, false);
		}
		if(root == p|| root ==q){
			return new Result(root, true);
		}
		Result rx = commonAncestorHelper1(root.left,p,q);
		if(rx.isAncestor)
			return rx;
		Result ry = commonAncestorHelper1(root.right, p,q);
		if(ry.isAncestor)
			return ry;
		
		if(rx.node!=null && ry.node!=null)
			return new Result(root,true);
		else if(root == p|| root== q){
			boolean isAncestor = rx.node!=null||ry.node!=null? true: false;
			return new Result(root,isAncestor);
		}else{
			return new Result(rx.node!=null? rx.node:ry.node, false);
		}
	}
	
	public static TreeNode commonAncestor1(TreeNode root, TreeNode p, TreeNode q){
		Result r = commonAncestorHelper1(root, p,q);
		if(r.isAncestor){
			return r.node;
		}
		return null;
	}
}

