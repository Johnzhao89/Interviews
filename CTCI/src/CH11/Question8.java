package CH11;

import java.util.*;
import CtCILibrary.*;

public class Question8{
	static class RankNode{
		public int left_size =0;
		public RankNode left;
		public RankNode right;
		public int data =0;
		
		public RankNode(int d){
			data = d;
		}
		public void insert(int d){
			if(d <=data){
				if(left!=null){
					left.insert(d);
				}else{
					left = new RankNode(d);
				}
				left_size++;
			}else{
				if(right!=null){
					right.insert(d);
				}else{
					right=new RankNode(d);
				}
			}
		}
		// 在本子树上的rank
		public int getRank(int d){
			if(d == data){
				return left_size;
			}else if(d < data){
				if(left==null)
					return -1;
				else
					return left.getRank(d);
			}else{
				int right_rank = right ==null? -1: right.getRank(d);
				if(right_rank == -1){
					return -1;
				}else{
					return left_size + 1 + right_rank;
				}
			}
		}
	}
	
	private static RankNode root =null;
	public static void track(int number){
		if(root == null){
			root = new RankNode(number);
		}else{
			root.insert(number);
		}
	}
	
	public static int getRankOfNumber(int number){
		return root.getRank(number);
	}
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		for (int i = 0; i < 100; i++) {
			int x = AssortedMethods.randomIntInRange(0, 100);
			track(x);	
		}
		
		for (int i = 0; i < 100; i++) {
			int rank1 = root.getRank(i);
			System.out.println(i + " has rank " + rank1);
		}
	}
}