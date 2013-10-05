package Tree;

public class Morris{
	// left root right
	public static void inMorrisTraversal2(TreeNode root){
		if(root == null) return;
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur!=null){
			//没有左后代，访问当前节点，跳到右节点
			if(cur.left==null){
				System.out.println(cur.val+" ");
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right!=null && pre.right!=cur){
					pre = pre.right;
				}//pre 左后代最右叶子节点 指向当前节点, 跳到左后代
				//表示当前节点的左子树未访问
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{//先输出当前再移向右子树
					pre.right = null;
					System.out.println(cur.val + " ");
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}
	// root left right
	public static void preMorrisTraversal(TreeNode root){
		if(root == null) return;
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur!=null){
			//无左后代,访问当前节点，
			if(cur.left == null){
				System.out.println(cur.val +" ");
				cur= cur.right;
			}else{
				pre = cur.left;
				while(pre.right!=null && pre.right!= cur){
					pre = pre.right;
				}
				//左后代的最右子节点指向当前节点
				if(pre.right == null){//先输出当前再移向左子树
					pre.right = cur;
					System.out.println(cur.val + " ");
					cur = cur.left;
				}else{
					pre. right = null;
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}
	// left right root
	public static void postMorrisTraversal(TreeNode root){
		if(root == null) return;
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur!=null){
			if(cur.left== null){
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right!=null && pre.right!=cur){
					pre = pre.right;
				}
				if(pre.right==null){
					pre.right = cur;
					cur = cur.left;
					System.out.println(cur.val +" ");
				}else{
					pre.right = null;
					cur = cur.right;
					System.out.println(cur.val +" ");
				}
			}
		}
		
	}
}
