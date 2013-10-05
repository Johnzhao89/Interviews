package Tree;

public class Morris{
	// left root right
	public static void inMorrisTraversal2(TreeNode root){
		if(root == null) return;
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur!=null){
			//û�����������ʵ�ǰ�ڵ㣬�����ҽڵ�
			if(cur.left==null){
				System.out.println(cur.val+" ");
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right!=null && pre.right!=cur){
					pre = pre.right;
				}//pre ��������Ҷ�ӽڵ� ָ��ǰ�ڵ�, ��������
				//��ʾ��ǰ�ڵ��������δ����
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{//�������ǰ������������
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
			//������,���ʵ�ǰ�ڵ㣬
			if(cur.left == null){
				System.out.println(cur.val +" ");
				cur= cur.right;
			}else{
				pre = cur.left;
				while(pre.right!=null && pre.right!= cur){
					pre = pre.right;
				}
				//�����������ӽڵ�ָ��ǰ�ڵ�
				if(pre.right == null){//�������ǰ������������
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
