package String;
/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * @author heguangliu
 *
 */
import java.util.*;
public class MinimumWindowSubstring{
	public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = S.length(), m = T.length();
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for(int i=0; i< m; i++){
        	map1.put(T.charAt(i),0);
        	if(map2.containsKey(T.charAt(i))){
        		map2.put(T.charAt(i), map2.get(T.charAt(i))+1);
        	}else{
        		map2.put(T.charAt(i), 1);
        	}
        }
        int start=0, end=0, found =0; 
        int minLength = Integer.MAX_VALUE;
        String result = new String();
        ArrayList<Integer> nexts = new ArrayList<Integer>();
        for(int i=0; i< S.length(); i++){
        	char c = S.charAt(i);
        	if(!map2.containsKey(c)){
        		continue;
        	}
        	nexts.add(i);
        	map1.put(c, map1.get(c)+1);
        	if(map1.get(c)<= map2.get(c))
        		found++;
        	if(found >= m){
        		char ll = S.charAt(nexts.get(start));
        		while(map1.get(ll)> map2.get(ll)){
        			map1.put(ll, map1.get(ll)-1);
        			ll= S.charAt(nexts.get(++start));
        		}
        		if(i- nexts.get(start)< minLength){
        			minLength = i+1 - nexts.get(start);
        			result = S.substring(nexts.get(start),i+1);
        		}
        	}
        }
        return result;
    }
}