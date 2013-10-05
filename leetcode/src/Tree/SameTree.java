package Tree;
/**
 * Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and 
the nodes have the same value.
 * @author heguangliu
 *
 */
import java.util.*;
public class SameTree{
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
	public boolean isSameTree2(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null || p.val!= q.val)
			return false;
		Queue<TreeNode> pque = new LinkedList<TreeNode>();
		Queue<TreeNode> qque =new LinkedList<TreeNode>();
		pque.offer(p); qque.offer(q);
		while(!pque.isEmpty() && !qque.isEmpty()){
			
		}
	}
}