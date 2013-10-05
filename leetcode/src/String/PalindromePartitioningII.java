package String;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * @author heguangliu
 *
 */
public class PalindromePartitioningII{
	
	public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length() <=1)
        	return 0;
        boolean[][] palindrome = buildPalindromeTable(s);
        int len = s.length();
        // cuts[i] = k, means the minimum cuts needed for s[i..len-1] is k
        int[] cuts = new int[len];
        cuts[len-1] = 0;
        for(int i=len -2; i>=0; i--){
        	if(palindrome[i][len-1])
        		cuts[i]=0;
        	else{// greedy is O(n) shenqi
        		cuts[i] = len -i;
        		for(int j =i; j< len-1; j++){
        			if(palindrome[i][j]){
        				cuts[i] = Math.min(cuts[i], 1+cuts[j+1]);
        			}
        		}
        	}
        }
        return cuts[0];
    }
	
	private boolean[][] buildPalindromeTable(String s){
		int len = s.length();
		boolean [][] T = new boolean[len][len];
		for(int i =0; i< len; i++){
			T[i][i] = true;
			int l = i-1, r = i+1;
			while(l>=0 && r<len && s.charAt(l) == s.charAt(r))
				T[l--][r++] = true;
			l =i; r = i+1;
			while(l>=0 && r<len && s.charAt(l) == s.charAt(r))
				T[l--][r++] = true;
		}
		return T;
	}
	
	// better one
	public int minCut2(String s){
		int len = s.length();
		boolean[][] palindrome = new boolean[len][len];
		int[] cuts = new int [len+1];
		cuts[len] = -1;
		for(int i = len-1; i>= 0; i--){
			cuts[i] = len -i;
			for(int j =i; j< len; j++){
				if(s.charAt(i)==s.charAt(j) && (j-i<2 || palindrome[i+1][j-1])){
					palindrome[i][j ]= true;
					cuts[i] = Math.min(cuts[i], 1+cuts[j+1]);
				}
			}
		}
		return cuts[0];
	}
	
}
