package Array;

import java.util.Arrays;

/**
 * Given a collection of numbers that might contain duplicates,
 *  return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 * @author heguangliu
 *
 */
import java.util.*;

public class PermutationII{
	// back track, import method, 
	 public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(num== null)
	        	return null;
	        Arrays.sort(num);
	        return perm(num, 0, new boolean[num.length]);
	 }
	 
	 public ArrayList<ArrayList<Integer>> perm(int[] num, int count, boolean[] used){
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 if(count == num.length)
			 result.add(new ArrayList<Integer>());
		 else{
			 for(int i=0; i< num.length; i++){
				 if(used[i] || i != 0 && num[i] == num[i-1] && used[i-1])
					 continue;
				 used[i]= true;
				 for(ArrayList<Integer> a: perm(num, count+1, used)){
					 a.add(0, num[i]);
					 result.add(a);
				 }
				 used[i] = false;
			 }
		 }
		 return result;
	 } 
	 
}