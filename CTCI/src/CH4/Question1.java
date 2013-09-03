package CH4;
import java.util.*;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 */
public class Question1{
	// bad version
	public static boolean isBalanced0(TreeNode root){
		if(root == null){
			return true;
		}
		int heightDiff = getHeight(root.left)-getHeight(root.right);
		if(Math.abs(heightDiff)>1){
			return false;
		}else{
			return isBalanced0(root.left)&& isBalanced0(root.right);
		}
	}
	public static int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	// better one
	public static boolean isBalanaced1(TreeNode root){
		if(checkHeight(root)==-1){
			return false;
		}else{
			return true;
		}
	}
	
	public static int checkHeight(TreeNode root){
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
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
}