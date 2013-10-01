package String;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author heguangliu
 *
 */
import java.util.*;

public class LongestPalindromicSubString {
	// bad one, expand around every center, O(N^2)
	public static String longestPalindrome2(String s){
		if(s == null || s.isEmpty())
			return new String();
		String longest = s.substring(0, 1);
		for(int i=0; i< s.length()-1; i++){
			String p1 = expandAroundCenter(s,i,i);
			if(p1.length() > longest.length())
				longest = p1;
			String p2 = expandAroundCenter(s, i, i+1);
			if (p2.length() > longest.length())
	            longest = p2;
		}
		return longest;
	}
	
	private static String expandAroundCenter(String s, int c1, int c2){
		int l = c1, r = c2;
		int n = s.length();
		while(l>=0 && r <= n-1 && s.charAt(l)== s.charAt(r)){
			l--;
			r++;
		}
		return s.substring(l+1, r);
	}
	public static String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.isEmpty())
			return new String();
		String t = preProcess(s);
		int n = t.length(), c = 0, r = 0;
		int[] p = new int[n];

		// p[i] indicate the max length palidrome which t[i] is the center
		for (int i = 1; i < n - 1; i++) {
			int i_mirror = 2 * c - i;
			p[i] = (r > i) ? Math.min(r - i, p[i_mirror]) : 0;
			//System.out.println("Current i:"+i+" r: "+r+" c: "+c+" p[i]: "+p[i]);
			while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i]))
				p[i]++;
			//System.out.println("After expand p[i]: "+p[i]);
			if (i + p[i] > r) {
				c =i;
				r = i + p[i];
			}
		}
		int maxLen =0;
		int centerIndex =0;
		for(int i =1; i< n-1; i++){
			if(p[i]> maxLen){
				maxLen = p[i];
				centerIndex = i;
			}
		}
		return s.substring((centerIndex -1- maxLen)/2, (centerIndex -1+ maxLen)/2);
	}

	public static String preProcess(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		sb.append("^");
		for (int i = 0; i < n; i++) {
			sb.append("#" + s.charAt(i));
		}
		sb.append("#$");
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(longestPalindrome2("abccbadsg;fahjkekf;qiewajbjksdlbbas,d"));
	}
}