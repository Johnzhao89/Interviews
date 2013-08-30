package CommDS;
import java.util.*;
/**
 * 
 * @author heguangliu
 * TreeNode and Tree separate version ,not preferred
 */
public class BinarySearchTree{
	private Node root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void add(Comparable obj){
		Node newNode = new Node();
		newNode.data=obj;
		newNode.left=null;
		newNode.right= null;
		if(root==null)
			root=newNode;
		else
			root.addNode(newNode);
	}
	
	public boolean find(Comparable obj){
		Node current = root;
		while(current!=null){
			int d= current.data.compareTo(obj);
			if(d==0)
				return true;
			else if(d >0)
				current = current.left;
			else
				current = current.right;
		}
		return false;
	}
	
	//need further review
	public void remove(Comparable obj){
		Node toBeRemoved = root;
		Node parent =null;
		boolean found = false;
		while(!found && toBeRemoved!=null){
			int d= toBeRemoved.data.compareTo(obj);
			if(d==0)
				found = true;
			else{
				parent = toBeRemoved;
				toBeRemoved= d >0? toBeRemoved.left:toBeRemoved.right;
			}
		}
		if(!found)
			return;
		if(toBeRemoved.left==null|| toBeRemoved.right==null){
			Node newChild;
			newChild= toBeRemoved.left==null? toBeRemoved.right:toBeRemoved.left;
			if(parent==null)
				root = newChild;
			else if(parent.left==toBeRemoved){
				parent.left=newChild;
			}else{
				parent.right= newChild;
			}
			return;
		}
		Node smallestParent=toBeRemoved;
		Node smallest=toBeRemoved.right;
		while(smallest.left!=null){
			smallestParent = smallest;
			smallest= smallest.left;
		}
		toBeRemoved.data=smallest.data;
		if(smallestParent==toBeRemoved){
			smallestParent.right=smallest.right;
		}else{
			smallestParent.left=smallest.right;
		}
	}
	
	public void print(){
		if(root!=null)
			root.printNodes();
	}
	
	
	class Node{
		public Comparable data;
		public Node left;
		public Node right;
		
		public void addNode(Node newNode){
			if(newNode.data.compareTo(data)<0){
				if(left==null){
					left = newNode;
				}else{
					left.addNode(newNode);
				}
			}else{
				if(right==null){
					right = newNode;
				}else{
					right.addNode(newNode);
				}
			}
		}
		public void printNodes(){
			if(left!=null)
				left.printNodes();
			System.out.println(data+" ");
			if(right!=null)
				right.printNodes();
		}
	}
}