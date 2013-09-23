package Array;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target. Note: Elements in a quadruplet (a,b,c,d) must be in
 * non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d) The solution set must not contain
 * duplicate quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and
 * target = 0. A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 * @author heguangliu
 * 
 */
import java.util.*;
public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length < 4)
			return result;
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		for(int i =0; i< num.length -3; i++)
			for(int j= i+1; j< num.length-2; j++)
				for(int m =j+1, n = num.length -1; m < n;){
					if(num[m] + num[n] == target - num[i]-num[j]){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.addAll(Arrays.asList(num[i], num[j], num[m++], num[n--]));
						set.add(temp);
					}else if(num[m]+num[n] < target - num[i]-num[j])
						m++;
					else 
						n--;
				}
		result.addAll(set);
		return result;
	}

}