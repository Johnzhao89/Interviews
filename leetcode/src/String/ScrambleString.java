package String;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * @author heguangliu
 * 
 */
import java.util.*;

public class ScrambleString {
	// best one, DP
	public static boolean isScramble(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		if(s1.equals(s2)) return true;
		// a table of matches T[i][j][k] = true iff s2.substring(j, j+k+1) is a scramble string of s1.substring(i,i+k+1)
		int len = s1.length();
		boolean[][][] scrambled = new boolean[len][len][len];
		for(int i=0; i<len; i++){
			for(int j =0; j< len; j++){
				scrambled[i][j][0] = (s1.charAt(i)== s2.charAt(j));
			}
		}
		for(int k=1; k< len; k++){
			for(int i=0; i< len-k; i++){
				for(int j =0; j< len-k; j++){
					scrambled[i][j][k] = false;
					for(int p=0; p< k; p++){
						if ((scrambled[i][j][p] && scrambled[i+p+1][j+p+1][k-p-1])  
					               || (scrambled[i][j+k-p][p] && scrambled[i+p+1][j][k-p-1])) {  
					             scrambled[i][j][k] = true;  
					             break;  
					           }  
					}
				}
			}
		}
		return scrambled[0][0][len-1]; 
	}
	
	// back track, still bad one
	public static boolean isScramble3(String s1, String s2) {
		return isScrambleHelper(s1, s2, new HashMap<String, String>());
	}

	private static boolean isScrambleHelper(String s1, String s2,
			HashMap<String, String> map) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2) || s2.equals(map.get(s1)))
			return true;
		int len = s1.length();
		for (int i = 1; i < len; i++) {
			String s1l = s1.substring(0, i), s1r = s1.substring(i, len);
			String s2l = s2.substring(0, i), s2r = s2.substring(i, len);
			if (isScramble3(s1l, s2l) && isScramble3(s1r, s2r)) {
				map.put(s1l, s2l);
				map.put(s1r, s2r);
				return true;
			}
			s2l = s2.substring(0, len - i);
			s2r = s2.substring(len - i, len);
			if (isScramble3(s1l, s2r) && isScramble3(s1r, s2l)) {
				map.put(s1l, s2r);
				map.put(s1r, s2l);
				return true;
			}
		}
		return false;
	}

	// very bad performance
	public static boolean isScramble2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int len = s1.length();
		if (s1.equals(s2))
			return true;
		for (int i = 1; i < len; i++) {
			String s1l = s1.substring(0, i), s1r = s1.substring(i, len);
			String s2l = s2.substring(0, len - i), s2r = s2.substring(i, len);
			if (isScramble2(s1l, s2l) && isScramble2(s1r, s2r))
				return true;
			s2l = s2.substring(0, len - i);
			s2r = s2.substring(len - i, len);
			if (isScramble2(s1l, s2r) && isScramble2(s1r, s2l))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isScramble("cacbcccbcbaccbabbc",
				"ccbbbcbbbacaaccccc"));
	}

}