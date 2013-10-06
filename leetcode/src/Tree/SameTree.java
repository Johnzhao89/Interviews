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
	//O(n) time, O(n) space
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
	
	//O(n) time, O(n) space
	// use ArrayDeque: add(E e), offer(E e), remove(), poll(), element(), getFirst(), getLast(), peek(), peekFirst(), peekLast()
	public boolean isSameTree2(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null || p.val!= q.val)
			return false;
		Queue<TreeNode> pque = new ArrayDeque<TreeNode>();
		Queue<TreeNode> qque =new ArrayDeque<TreeNode>();
		pque.offer(p); qque.offer(q);
		while(!pque.isEmpty() && !qque.isEmpty()){
			TreeNode pp = pque.remove();
			TreeNode qq = qque.remove();
			if(pp.left!=null && qq.left!=null && pp.left.val== qq.left.val){
				pque.add(pp.left); qque.add(qq.left);
			}else if(!(pp.left == null && qq.left == null)){
				return false;
			}
			if(pp.right!=null && qq.right!=null && pp.right.val == qq.right.val){
				pque.add(pp.right); qque.add(qq.right);
			}else if(!(pp.right==null && qq.right == null)){
				return false;
			}
		}
		return pque.isEmpty() && qque.isEmpty();
	}
}