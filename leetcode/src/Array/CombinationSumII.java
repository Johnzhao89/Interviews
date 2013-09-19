package Array;

/**
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 Each number in C may only be used once in the combination.
 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 A solution set is: 
 [1, 7] 
 [1, 2, 5] 
 [2, 6] 
 [1, 1, 6] 
 * @author heguangliu
 */

import java.util.*;

public class CombinationSumII {
	// no map anymore, because you cannot distinguish which one is with dup version
	public ArrayList<ArrayList<Integer>> combinationSum2I(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(num);
		ArrayList<ArrayList<ArrayList<Integer>>> values = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
		tmp.add(new ArrayList<Integer>());
		values.add(tmp);
		for (int j = 1; j <= target; j++) {
			values.add(null);
		}
		for (int c : num) {// increase index , lead to no duplicate
			for (int v = target; v >= c; v--) { // notice v>=c, not v>=0, this
												// difference lead to no
												// duplicate
				if (values.get(v - c) != null) {
					ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
					for (ArrayList<Integer> t : values.get(v - c)) {
						ArrayList<Integer> tt = new ArrayList<Integer>(t);
						tt.add(c);
						temp.add(tt);
					}
					if (values.get(v) == null) {
						values.set(v, temp);
					} else {
						values.get(v).addAll(temp);
					}
				}
			}
		}
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		if (values.get(target) == null) {
			return new ArrayList<ArrayList<Integer>>();
		} else {
			set.addAll(values.get(target));
			return new ArrayList<ArrayList<Integer>>(set);
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> tuples = new ArrayList<ArrayList<Integer>>();
		combinationSum2(num, target, new ArrayList<Integer>(), tuples);
		return tuples;
	}

	// proposed by chenwang
	public void combinationSum2(int[] num, int target,
			ArrayList<Integer> partial, ArrayList<ArrayList<Integer>> tuples) {
		ArrayList<Integer> tuple;
		if (num.length == 0)
			return;
		int i = 0;
		while (i < num.length) {
			int k = 0;
			while (k + i < num.length && num[k + i] == num[i])
				k++;
			for (int l = 1; l <= k; l++) {
				tuple = (ArrayList<Integer>) partial.clone();
				int m = l;
				while (m-- > 0)
					tuple.add(num[i]);
				int diff = target - l * num[i];
				if (diff == 0) {
					tuples.add(tuple);
					break;
				} else if (diff < 0) {
					return;
				} else if (diff < num[i]) {
					break;
				} else {
					combinationSum2(Arrays.copyOfRange(num, i + k, num.length),
							target - l * num[i], tuple, tuples);
				}
			}
			i += k;
		}
	}
}