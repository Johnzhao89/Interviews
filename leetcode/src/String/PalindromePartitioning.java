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
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        partitionHelper(s, 0, palindromeTable(s), results);
        return results;
    }
	
	//T[i][j] == true, if s[i..j] is true
	private boolean[][] palindromeTable(String s){
		boolean[][] T = new boolean[s.length()][s.length()];
		for(int i=0; i< s.length(); i++) T[i][i] = true;
		
		for(int i=1; i< s.length(); i++){
			int l =i-1, r =i;
			while(l>= 0 && r< s.length() && s.charAt(l) == s.charAt(r))
				T[l--][r++] = true;
			l = i-1; r = i+1;
			while(l>= 0 && r< s.length() && s.charAt(l) == s.charAt(r))
				T[l--][r++]= true;
		}
		return T;
	}
	
	// return all the partition of substring l.. s.len-1
	private void partitionHelper(String s, int l, boolean[][] T, ArrayList<ArrayList<String>> results){
		if(l == s.length()){
			results.add(new ArrayList<String>());
		}
		for(int i=l; i< s.length(); i++){
			if(T[l][i]){
				ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
				partitionHelper(s, i+1, T, res);
				for(ArrayList<String> partition: res){
					partition.add(0, s.substring(l, i+1));
				}
				results.addAll(res);
			}
		}
	}
	
}