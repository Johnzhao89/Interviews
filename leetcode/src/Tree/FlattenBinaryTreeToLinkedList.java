package Tree;

/**
 * Given a binary tree, flatten it to a linked list in-place.
For example,
Given
         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author heguangliu
 *
 */

public class FlattenBinaryTreeToLinkedList{
	// root-> left-> right
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        flattenHelper(root);
    }
	public TreeNode flattenHelper(TreeNode root){
		if(root == null) return root;
		TreeNode rtree = root.right;
		if(root.left!=null){
			root.right = root.left;
			root.left = null;
			root = flattenHelper(root.right);
		}
		if(rtree!=null){
			root.right = rtree;
			root=flattenHelper(rtree);
		}
		return root;
	}
	
	public void flattenMorris(TreeNode root){
		TreeNode cur = root;
		while(cur!=null){
			if(cur.left==null)
				cur=cur.right;
			else{
				if(cur.right!=null){
					TreeNode next = cur.left;
					while(next.right!=null) next = next.right;
					next.right = cur.right;
				}
				cur.right = cur.left;
				cur.left = null;
			}
		}
	}
}