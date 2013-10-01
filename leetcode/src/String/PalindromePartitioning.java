package String;
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
 * @author heguangliu
 *
 */
import java.util.*;
public class PalindromePartitioning{
	public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0)
        	return result;
        ArrayList<String> first = new ArrayList<String>();
        first.add(s.charAt(0)+"");
        if(s.length()>0){
        	partition(1, s, result);
        }
    }
	
	public void partition(int index, String s, ArrayList<ArrayList<String>> result){
		if(index >= s.length())
			return;
		int i =0;
		
		
	}
	

}