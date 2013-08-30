package CommDS;
import java.util.*;
/**
 * 
 * @author heguangliu
 *
 */
public class BTree{
	private int value;
	private BTree left;
	private BTree right;
	private BTree parent;
	
	public BTree(){
	}
	
	public BTree(int v){
		this.value=v;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public static BTree createMinimalBT(BTree root, int[] array, int s, int e){
		if(s >= 0 && e <= array.length - 1 && s<= e){
			int m = (e + s)/2;
			root = new BTree(array[m]);
			root.left = createMinimalBT(root.left, array, s, m-1);
			root.right = createMinimalBT(root.right, array, m+1, e);
			return root;
		}else {
			return root;
		}
	}
	//build a BST, other than a BTree
	public static void insertNode(BTree node, int v){
		if( node!= null){
			if(v <= node.value){
				if(node.left==null){
					node.left = new BTree(v);
					node.left.parent = node;
				}else{
					insertNode(node.left,v);
				}
			}else{
				if(node.right ==null){
					node.right = new BTree(v);
					node.right.parent = node;
				}else{
					insertNode(node.right,v);
				}
			}
		}
	}
	//BT
	public static void showByLevel(BTree root){
		if(root == null)
			return;
		Queue<BTree> current = new LinkedList<BTree>();
		Queue<BTree> next = new LinkedList<BTree>();
		current.add(root);
		System.out.println(root.value);
		while(!current.isEmpty()){
			BTree node = current.poll();
			if(node.left!=null){
				next.add(node.left);
				System.out.println(node.left.value+"\t");
			}
			if(node.right!=null){
				next.add(node.right);
				System.out.println(node.right.value+"\t");
			}
			if(current.isEmpty()){
				current.addAll(next);
				next.clear();
				System.out.println();
			}
		}
	}
	//BT
	public static int width(BTree root){
		if(root == null)
			return 0;
		Queue<BTree> current = new LinkedList<BTree>();
		Queue<BTree> next = new LinkedList<BTree>();
		current.add(root);
		int width = 1;
		while(!current.isEmpty()){
			BTree node = current.poll();
			if(node.left!=null){
				next.offer(node.left);
			}
			if(node.right!=null){
				next.offer(node.right);
			}
			if(current.isEmpty()){
				if(next.size()>width)
					width=next.size();
				current.addAll(next);
				next.clear();
			}
		}
		return width;
	}
	//BT
	public static int height(BTree node){
		if(node == null)
			return 0;
		else
			return Math.max(height(node.left), height(node.right))+1;
	}
	//BT
	public static int checkHeight(BTree root){
		if(root == null){
			return 0;
		}
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1){
			return -1;
		}
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1){
			return -1;
		}
		int heightDiff= leftHeight - rightHeight;
		if(Math.abs(heightDiff)>1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight);
		}
	}
	//BT
	public static boolean isBalanced(BTree root){
		if(checkHeight(root)==-1)
			return false;
		else
			return true;
	}
	//BT
	public static int treeSize(BTree root){
		if(root == null)
			return 0;
		else
			return treeSize(root.left)+treeSize(root.right)+1;
	}
	//BST
	public static boolean containTree(BTree t1, BTree t2){
		if(t1==null || t2==null){
			return false;
		}
		if(t1.value == t2.value){
			return matchTree(t1.left, t2.left) && matchTree(t1.right,t2.right);
		}else{
			return t1.value<t2.value? containTree(t1.right,t2): containTree(t1.left,t2);
		}
	}
	
	public static boolean matchTree(BTree t1,BTree t2){
		if(t1==null && t2 == null){
			return true;
		}else if(t1!=null && t2!=null){
			return t1.value==t2.value? matchTree(t1.left,t2.left)&& matchTree(t1.right,t2.right):false;
		}else{
			return false;
		}
	}
	
	public static BTree leftMostNode(BTree node){
		
	}
	
	public static BTree inorderSuc(BTree root, int k){
		
	}
	
	public static BTree preOrderSuc(BTree node, int k){
		
	}
	
	public static BTree postOrderSuc(BTree node, int k){
		
	}
	
	public static BTree commonRoot(BTree root, BTree p, BTree q){
		
	}
	
	public static void findAllPathSum(BTree root, int k,  ArrayList<BTree>p, ArrayList<ArrayList<BTree>> all){
		
	}
	
	public static ArrayList<ArrayList<BTree>> findAllPathSum(BTree root, int k){
		
	}
	
	public static boolean coverNode(BTree root, BTree p){
		
	}
	
	
}