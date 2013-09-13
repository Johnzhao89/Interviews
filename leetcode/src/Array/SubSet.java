package Array;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * @author heguangliu
 *
 */
import java.util.*;

public class SubSet {
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(S);
		result.add(new ArrayList<Integer>());
		ArrayList<Integer> b= new ArrayList<Integer>();
		b.add(S[0]);
		result.add(b);
		for (int i = 1; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> a : result) {
				a.add(S[i]);
				temp.add(a);
			}
			result.addAll(temp);
		}
		return result;
	}
	
	public static void main(String[] args){
		subsets(new int[]{-1, 1, 2});
	}
}