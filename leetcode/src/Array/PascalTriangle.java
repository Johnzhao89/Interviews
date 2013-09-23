package Array;
/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author heguangliu
 *
 */
import java.util.*;
public class PascalTriangle{
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0)
        	return result;
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        
        for(int i = 2; i <= numRows ; i++){
        	ArrayList<Integer> curr= new ArrayList<Integer>(i);
        	ArrayList<Integer> prev = result.get(i-2);// length = i-1
        	curr.add(1);
        	for(int j = 1; j< i-1; j++){
        		curr.add(prev.get(j)+prev.get(j-1));
        	}
        	curr.add(1);
        	result.add(curr);
        }
        return result;
	}
}