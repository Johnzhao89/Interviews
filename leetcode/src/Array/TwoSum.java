package Array;
/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must 
  be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

  You may assume that each input would have exactly one solution.
 * @author heguangliu
 *
 */
// pass
import java.util.*;
public class TwoSum{
	
	//hashmap
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = {-1, -1};
		for(int i=0; i<numbers.length;i++){
			map.put(numbers[i], i);
		}
		for(int i=0; i<numbers.length; i++){
			if(map.containsKey(target - numbers[i])){
				int j = map.get(target - numbers[i])+1;
				i =i+1;
				result[0]=(i<j)? i:j;
				result[1]=(i<j)? j:i;
				return result;
			}
		}
		return result;
    }
	
	//O(1) extra space, O(n) sort
	public int[] twoSum1(int[] numbers, int target){
		// Start typing your Java solution below
        // DO NOT write main() function
		if(numbers == null || numbers.length == 0)
			return new int[2];
		int[] nums = numbers.clone();
		Arrays.sort(numbers);
		int i =0;
		int j = numbers.length -1;
		while(i < j){
			if(numbers[i]+numbers[j] == target){
				break;
			}else if(numbers[i]+numbers[j] < target){
				i++;
			}else{
				j--;
			}
		}
		int[] result = {-1, -1};
		for(int k = 0; k<nums.length; k++){
			if(numbers[i] == nums[k] && result[0] == -1){
				result[0] = k+1;
			}
			else if(numbers[j] == nums[k]&& result[1] == -1){
				result[1] = k+1; 
			}
		}
		Arrays.sort(result);
		return result;
	}
}