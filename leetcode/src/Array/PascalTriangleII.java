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
public class PascalTriangleII{
	
	public ArrayList<Integer> getRow(int rowIndex){
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
        	result.add(0, 1);
        	for(int j=1; j< i; j++){
        		result.set(j, result.get(j)+ result.get(j+1));
        	}
        }
        return result;
    }
}