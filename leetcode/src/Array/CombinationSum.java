package Array;

/**
 * Given a set of candidate numbers (C) and a target number (T),
 *  find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 * @author heguangliu
 *
 */

import java.util.*;

public class CombinationSum{
	// forward DP
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(candidates == null || candidates.length ==0)
        	return new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        
        for(int i=1; i<=target; i++){
        	ArrayList<ArrayList<Integer>> v = new ArrayList<ArrayList<Integer>>();
        	for(int j=0; j<= candidates.length; j++){// notice j=0 , not j=c
        		if(i == candidates[j]){
        			ArrayList<Integer> temp = new ArrayList<Integer>();
        			temp.add(i);
        			v.add(temp);
        		}else if(i> candidates[j]){
        			int prev_num = i-candidates[j];
        			ArrayList<ArrayList<Integer>> prev = map.get(prev_num);// here lead to duplicate
        			if(prev!=null){
        				for(ArrayList<Integer> list: prev){
        					if(list.get(list.size() -1) <= candidates[j]){
        						ArrayList<Integer> new_list = new ArrayList<Integer>(list);
        						new_list.add(candidates[j]);
        						v.add(new_list);
        					}
        				}
        			}
        		}
        	}
        	if(v.size() > 0){
        		map.put(i, v);
        	}
        }
        if(map.get(target) == null)
        	return new ArrayList<ArrayList<Integer>>();
        return map.get(target);
    }
	
	// DFS good choice, this idea is used widely
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		dfs(result, tmp, candidates, target, 0);
		return result;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp, int[] cand, int target, int pos){
		if(target<0) return;  
        if(target==0){  
            result.add(new ArrayList<Integer>(tmp));  
            return;  
        } 
        for(int i = pos; i<cand.length; i++){
        	tmp.add(cand[i]);
        	dfs(result, tmp, cand, target-cand[i],i);
        	tmp.remove(tmp.size()-1);
        }
	}
	
}