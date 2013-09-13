package Array;
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
    The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},
    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 * @author heguangliu
 *
 */

// passed
import java.util.*;

public class ThreeSum{
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        Set<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>();
        for(int i=0; i< num.length-2; i++){
        	int j= i+1;
        	int k = num.length-1;
        	int target = -num[i];
        	
        	while(j < k){
        		if(num[j]+num[k] < target){
        			j++;
        		}else if(num[j]+ num[k] > target){
        			k--;
        		}else{
        			ArrayList<Integer> r = new ArrayList<Integer>();
        			r.add(num[i]);
        			r.add(num[j]);
        			r.add(num[k]);
        			Collections.sort(r);
        			s.add(r);
        			j++; k--;
        		}
        	}
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.addAll(s);
        return result;
    }
}