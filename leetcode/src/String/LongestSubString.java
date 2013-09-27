package String;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author heguangliu
 * 
 */
import java.util.*;
public class LongestSubString {
	public static int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.isEmpty())
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength =0, start =0, i=0;
		for(; i< s.length() ;i++){
			char c = s.charAt(i);
			if(map.containsKey(c) && map.get(c)>= start){
				maxLength = Math.max(maxLength, i-start);
				start = map.get(c)+1;
			}
			map.put(c, i);
		}
		maxLength = Math.max(maxLength, i-start);
		return maxLength;
	}
}