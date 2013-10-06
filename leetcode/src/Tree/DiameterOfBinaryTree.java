package Tree;
/**
 * The diameter of a tree (sometimes called the width) is the number of nodes 
 * on the longest path between two leaves in the tree. The diagram below shows 
 * two trees each with diameter nine, the leaves that form the ends of a longest 
 * path are shaded (note that there is more than one path in each tree of length nine, 
 * but no path longer than nine nodes).
 * @author heguangliu
 *
 */
public class DiameterOfBinaryTree{
	private class Data{
		public int height;
		public int diameter;
	}
	public int diameter(TreeNode root) {
		Data data = new Data();
		diameter(root, data);
		return data.diameter;
	}
	private void diameter(TreeNode root, Data d){
		if(root == null){
			d.height = 0;
			d.diameter = 0;
			return;
		}
		Data dataL = new Data();
		dataL.height=d.height;
		dataL.diameter=d.diameter;
		diameter(root.left, dataL);
		
		Data dataR = new Data();
		dataR.height=d.height;
		dataR.diameter=d.diameter;
		diameter(root.right,dataR);
		d.diameter=Math.max(Math.max(dataL.diameter, dataR.diameter), dataL.height+dataR.height+1);
		d.height=Math.max(dataL.height, dataR.height)+1;
	}
}