package CH4;
import java.util.*;
import CtCILibrary.*;

public class Question5{
	
	public static boolean checkBST0(TreeNode n, int min, int max){
		if(n == null){
			return true;
		}
		if(n.data <=min || n.data>max){
			return false;
		}
		if(!checkBST0(n.left,min,n.data)||!checkBST0(n.right,n.data,max)){
			return false;
		}
		return true;
	}
	
	public static boolean checkBST0(TreeNode n){
		return checkBST0(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		int[] array = {3, 5, 7};
		TreeNode node = TreeNode.createMinimalBST(array);
		node.left.data = 5;
		System.out.println(checkBST0(node));
	}
}