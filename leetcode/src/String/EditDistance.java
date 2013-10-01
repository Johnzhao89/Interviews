package String;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.) You have the
 * following 3 operations permitted on a word: a) Insert a character b) Delete a
 * character c) Replace a character
 * 
 * @author heguangliu
 * 
 */
public class EditDistance {
	// worst one
	public int minDistance2(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (word1 == null || word2 == null)
			return -1;
		return minDistance2(word1, word2, word1.length(), word2.length());
	}

	private int minDistance2(String w1, String w2, int l1, int l2) {
		if (l1 == 0 || l2 == 0)
			return l1 == 0 ? l2 : l1;
		return Math.min(
				Math.min(minDistance2(w1, w2, l1 - 1, l2) + 1,
						minDistance2(w1, w2, l2, l2 - 1) + 1),
				minDistance2(w1, w2, l1 - 1, l2 - 1)
						+ (w1.charAt(l1 - 1) == w2.charAt(l2 - 1) ? 0 : 1));
	}

	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null)
			return -1;
		int l1 = word1.length(), l2 = word2.length();
		if(l1 ==0 || l2 == 0) return l1==0? l2: l1;
		int[][] matrix = new int[l1][l2];
		matrix[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;

		for (int i = 1; i < l1; i++) {
			matrix[i][0] = Math.min(matrix[i - 1][0] + 1,
					(word1.charAt(i) == word2.charAt(0) ? i : i + 1));
		}
		for (int j = 1; j < l2; j++) {
			matrix[0][j] = Math.min(matrix[0][j - 1] + 1,
					(word1.charAt(0) == word2.charAt(j)) ? j : j + 1);
		}
		for(int i=1; i< l1; i++){
			for(int j=1; j< l2; j++){
				matrix[i][j]=Math.min(Math.min(matrix[i][j-1]+1,matrix[i-1][j]+1), matrix[i-1][j-1]+(word1.charAt(i)== word2.charAt(j)?0:1));
			}
		}
		return matrix[l1-1][l2-1];
	}
}