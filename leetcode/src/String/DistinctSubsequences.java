package String;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some 
(can be none) of the characters without disturbing the relative positions of the remaining characters.
 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
 * @author heguangliu
 *
 */
public class DistinctSubsequences{
	//space O(i*j) space, bad one
	// table[i][j] = the number of distinct subseq of T[0..j] in S[0..i]
	// F(i,j) = f(i-1, j)+s[i]==t[j]? f(i-1,j-1)+0;
	public int numDistinct(String S, String T){
		if(S==null ||T==null||S.length()==0 || S.length()< T.length())
        	return 0;
		int[][] count = new int[S.length()][T.length()];
		count[0][0] = S.charAt(0)==T.charAt(0)? 1:0;
		for(int i=1; i< S.length(); i++){
			for(int j=0; j<T.length(); j++){
				count[i][j]=count[i-1][j];
				if(S.charAt(i)==T.charAt(j)){
					count[i][j]+= j==0? 1: count[i-1][j-1];
				}
			}
		}
		return count[S.length()-1][T.length()-1];
	}
	
	//in ith at beginning, count[i]= T[0..j]in S[0.. i-1]-> S[0..i];
	public int numDistinct2(String S, String T){
		if(S==null || T== null || S.length()==0 || S.length()< T.length())
			return 0;
		int[] count = new int[T.length()];
		for(int i=0; i< S.length(); i++){
			for(int j = Math.min(i, T.length()-1); j>=0; j--){// backward
				if(S.charAt(i)== T.charAt(j))
					count[j]+=(j==0)? 1: count[j-1];
			}
		}
		return count[T.length()-1];
	}
}