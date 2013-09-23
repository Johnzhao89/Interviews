package Array;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 * @author heguangliu
 *assume no duplicate
 */
import java.util.*;

public class LongestConsecutiveSequence{
	public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length == 0)
        	return 0;
        HashMap <Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int n : num)
        	map.put(n, false);
        int longestLength =0;
        for(int n: num){
        	if(!map.get(n)){
        		map.put(n, true);
        		int len = findConsecutive(map,n+1,1 )+1+ findConsecutive(map, n-1, -1);
        		longestLength = Math.max(len, longestLength); 
        	}
        }
        return longestLength;
    }
	public int findConsecutive(HashMap<Integer, Boolean> map, int num, int step){
		int len =0;
		while(map.containsKey(num)){
			len++;
			map.put(num, true);
			num += step;
		}
		return len;
	}
	
	// another merge version, many dup insert, but can learn this method
	public int longestConsecutive2(int[] num) {
		if(num == null || num.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max =1;
		for(int n: num){
			if(map.containsKey(n)) continue;
			map.put(n, 1);
			if(map.containsKey(n - 1)){
				max = Math.max(max, merge(map, n-1, n));
			}
			if(map.containsKey(n + 1)){
				max = Math.max(max, merge(map, n, n+1));
			}
		}
		return max;
	}
	// just care about bound, but every one has been bound once
	public int merge(HashMap<Integer, Integer> map, int left, int right){
		int upper =  right + map.get(right)-1 ;
		int lower = left - map.get(left) + 1;
		int len = upper - lower +1;
		map.put(upper, len);
		map.put(lower, len);
		return len;
	}
}