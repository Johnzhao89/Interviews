package Array;
/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author heguangliu
 *
 */
import java.util.*;
public class SubSetII{
	// better one, no extra space
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    result.add(new ArrayList<Integer>());
	    Arrays.sort(num);
	    
	    int previousSize =0;
	    for(int i=0; i< num.length;i++){
	    	int size = result.size();
	    	for(int j=0; j<size; j++){
	    		if(i==0 || num[i]!=num[i-1]|| j>=previousSize){
	    			ArrayList<Integer> a = new ArrayList<Integer>(result.get(j));
	    			a.add(num[i]);
	    			result.add(a);
	    		}
	    	}
	    	previousSize = size;
	    }
	    return result;
	}
	
	//hashSet version, extra space, bad
	public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        return subsetsWithDup(num, num.length-1, new HashSet<ArrayList<Integer>>());
    }
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, int index, HashSet<ArrayList<Integer>> set){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(index <0){
			result.add(new ArrayList<Integer>());
		}else{
			result = subsetsWithDup(num, index -1, set);
			int size = result.size();
			for(int i=0; i<size; i++){
				ArrayList<Integer> tmp = new ArrayList<Integer>(result.get(i));
				tmp.add(num[index]);
				if(!set.contains(tmp)){
					result.add(tmp);
					set.add(tmp);
				}
			}
		}
		return result;
	}
}