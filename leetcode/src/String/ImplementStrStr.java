package String;

/**
 * Implement strStr().
Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * @author heguangliu
 * wanna commit suicide read KMP!!!
 * rolling hash works better for me: http://yyeclipse.blogspot.com/2013/02/leetcode-implement-strstr-string.html
 *
 */
public class ImplementStrStr{
	// brute force
	public String strStr2(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n =haystack.length(), m = needle.length();
        if(m == 0) return haystack;
        if(n < m)  return null;
        for(int i=0; i< n-m +1; ++i){
        	int start =0;
        	for(int offset = i; start< m && haystack.charAt(offset)==needle.charAt(start); offset++, start++);
        	if(start == m) 
        		return new String(haystack.substring(i));
        }
        return null;
    }
	private void buildNextTable(String pattern, int[] next){
		next[0] = -1;
		for(int i =2; i<=pattern.length(); ++i){
			int j =next[i-1];
			while(j >-1 && pattern.charAt(i-1)!=pattern.charAt(j))
				j = next[j];
		}
	}
	//... 
	public static String strStr(String haystack, String needle) {
        if(haystack == null && needle == null) return new String("");
        if(haystack.length() < needle.length()) return null;
        if(needle == null || needle.length() == 0) return haystack;
        int[] p = prefix(needle);
        int k = -1;
        for(int i = 0; i < haystack.length(); i++){ //i starts from 0
            while(k > -1 && needle.charAt(k+1) != haystack.charAt(i))
                k = p[k];     //k shift p[k] to right
            if(needle.charAt(k+1) == haystack.charAt(i)) // no k > -1 inside if. 
                k++;
            if(k == needle.length() - 1)     //k is index, so it's k == needle.length() - 1, not k == needle.length().
                return haystack.substring(i - k); // i is index, k is index, so can do subtract operation .
        }
        
        return null;     
    }
    //find the last position in [0..i-1] that have an overlapping prefix
    public static int[] prefix(String needle){
        int[] p = new int[needle.length()];
        int k = -1;
        p[0] = -1;
        
        for(int i = 1; i < needle.length(); i++){ // i starts from 1; 
            while(k > -1 && needle.charAt(k+1) != needle.charAt(i))
                k = p[k];
            if(needle.charAt(k + 1) == needle.charAt(i))
                k = k + 1;
            p[i] = k;
        }
        for(int i=0; i<needle.length(); i++){
        	System.out.print(p[i]);
        }
        return p;
    }
	
    public static void main(String[] args){
    	System.out.println(strStr("BCABABACRKKFABACABABAC","ABCABCABCABABCCCC"));
    }
    
}