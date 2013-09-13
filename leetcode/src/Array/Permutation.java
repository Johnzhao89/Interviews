package Array;

/**
 * Given a collection of numbers, return all possible permutations.
 For example,
 [1,2,3] have the following permutations: without duplicate
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author heguangliu
 *
 */
import java.util.*;

public class Permutation {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		result.get(0).add(num[0]);// add first element
		
		for (int i = 1; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> a : result) {
				temp.addAll(insert(a, num[i]));
			}
			result.clear();
			result = temp;
		}
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> insert(ArrayList<Integer> a , int n){
		ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(n);
		temp.addAll(new ArrayList<Integer>(a));
		res.add(temp);
		for(int i=1; i<=a.size(); i++){
			temp=new ArrayList<Integer>();
			temp.addAll(new ArrayList<Integer>(a.subList(0, i)));
			temp.add(n);
			temp.addAll(new ArrayList<Integer>(a.subList(i, a.size())));
			res.add(temp);
		}
		return res;
	}
	
	
}