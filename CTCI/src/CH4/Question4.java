package CH4;
import java.util.*;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 *
 */
public class Question4{
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root!=null){
			current.add(root);
		}
		while(current.size()>0){
			result.add(current);
			LinkedList<TreeNode> parents = current;
			for(TreeNode parent: parents){
				if(parent.left!=null){
					current.add(parent.left);
				}
				if(parent.right!=null){
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	//pre order traversal, root left right,depth first
	public static void createLevelLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		if(root == null) return;
		LinkedList<TreeNode> list = null;
		if(lists.size() == level){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedListDFS(root.left,lists,level+1);
		createLevelLinkedListDFS(root.right,lists,level+1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedListDFS(root, lists, 0);
		return lists;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth=0;
		for(LinkedList<TreeNode> entry: result){
			Iterator<TreeNode> i = entry.listIterator();
			System.out.println("Link list at depth "+ depth+":");
			while(i.hasNext()){
				System.out.println(" "+((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	
	public static void main(String[] args){
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedListBFS(root);
		printResult(list);
	}
}