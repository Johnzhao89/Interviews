package String;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "*") ¡ú true
 isMatch("aa", "a*") ¡ú true
 isMatch("ab", "?*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú false
 * @author heguangliu
 *
 */
import java.util.*;


public class WildcardMatching {
	// hard to think
	public static boolean isMatch(String s, String p) {
		int plenNoStar = 0;
		for (char c : p.toCharArray())
			if (c != '*')
				plenNoStar++;
		if (plenNoStar > s.length())
			return false;
		s = " " + s;
		p = " " + p;
		int slen = s.length();
		int plen = p.length();
		boolean[] dp = new boolean[slen];
		TreeSet<Integer> firstTrueSet = new TreeSet<Integer>();
		firstTrueSet.add(0);
		dp[0] = true;
		boolean allStar = true;

		for (int pi = 1; pi < plen; pi++) {
			if (p.charAt(pi) != '*')
				allStar = false;
			for (int si = slen - 1; si >= 0; si--) {
				if (si == 0) {
					dp[si] = allStar ? true : false;
				} else if (p.charAt(pi) != '*') {
					if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')
						dp[si] = dp[si - 1];
					else
						dp[si] = false;
				} else {
					int firstTruePos = firstTrueSet.isEmpty() ? Integer.MAX_VALUE
							: firstTrueSet.first();
					dp[si] = si >= firstTruePos? true: false; 
				}
				if(dp[si]) firstTrueSet.add(si);
				else firstTrueSet.remove(si);
				System.out.println("dp[ pi:"+pi+", si: "+si+"]="+dp[si]);
				System.out.println("First true set:"+firstTrueSet);
			}
		}
		return dp[slen - 1];
	}
	
	public boolean isMatch2(String s, String p) {  
		   if (s == null || p == null) return false;  
		   // calculate count for non-wildcard char  
		   int count = 0;  
		   for (Character c : p.toCharArray()) {  
		     if (c != '*') ++count;  
		   }  
		   // the count should not be larger than that of s  
		   if (count > s.length()) return false;  
		   
		   boolean[] matches = new boolean[s.length()+1];  
		   matches[0] = true;  
		   int pid = 0, firstMatch = 0;  
		   while (pid < p.length()) {  
		     // skip duplicate '*'  
		     if (pid > 0 && p.charAt(pid) == '*' && p.charAt(pid-1) == '*') {  
		       ++pid;  
		       continue;  
		     }  
		   
		     // if '*', fill up the rest of row  
		     if (p.charAt(pid) == '*') {  
		       // fill up the rest of row with true, up to the first match in previous row  
		       for (int i = firstMatch+1; i <= s.length(); ++i) matches[i] = true;  
		     } else {  
		       // fill up backwards:  
		       // - set to true if match current char and previous diagnal also match  
		       // - otherwise, set to false  
		       int match = -1;  
		       for (int i=s.length(); i>firstMatch; --i) {  
		         matches[i] = (p.charAt(pid) == s.charAt(i-1) || p.charAt(pid) == '?')  
		               && matches[i-1];  
		         if (matches[i]) match = i;  
		       }  
		       if (match < 0) return false;  
		       firstMatch = match;  
		     }  
		   
		     ++pid;  
		   }  
		   
		   return matches[s.length()];  
		 }  
	
	public static void main(String[] args){
		System.out.println(isMatch("aaabaaa","a**aba*"));
	}
}