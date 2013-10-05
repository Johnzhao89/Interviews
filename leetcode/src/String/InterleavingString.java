package String;

import java.lang.reflect.Array;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example, Given: s1 = "aabcc", s2 = "dbbca", When s3 = "aadbbcbcac",
 * return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author heguangliu
 * 
 */
public class InterleavingString {

	// better one DP
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null
				|| s1.length() + s2.length() != s3.length())
			return false;
		// matrix[i][j]= true means s1[i-1] s2[j-1] matches s3[i+j-1];
		boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
		matrix[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			matrix[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1)
					&& matrix[i - 1][0] ? true : false;
		}
		for (int j = 1; j <= s2.length(); j++) {
			matrix[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1)
					&& matrix[0][j - 1] ? true : false;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				matrix[i][j] = ((s1.charAt(i-1) == s3.charAt(i + j-1)
						&& matrix[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i + j-1)
						&& matrix[i][j-1]));
			}
		}
		return matrix[s1.length()][s2.length()];
	}

	// bad one, using recursive
	public static boolean isInterleave2(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1 == null || s2 == null || s3 == null
				|| s1.length() + s2.length() != s3.length())
			return false;
		return isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0,
				s3.toCharArray());
	}

	public static boolean isInterleave(char[] array1, int i, char[] array2,
			int j, char[] array3) {
		if (i == array1.length && j == array2.length)
			return true;
		int k = i + j;
		boolean b1 = false, b2 = false;
		if (i != array1.length) {
			b1 = (array3[k] == array1[i])
					&& isInterleave(array1, i + 1, array2, j, array3);
			if (b1)
				return true;
		}
		if (j != array2.length) {
			b2 = (array3[k] == array2[j])
					&& isInterleave(array1, i, array2, j + 1, array3);
			if (b2)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isInterleave("a","b","ab"));
	}

}