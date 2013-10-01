package String;

/**
 * Write a function to find the longest common prefix string amongst an array of strings
 * @author heguangliu
 *
 */
public class LongestCommonPrefix{
	public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs==null || strs.length ==0)
        	return new String();
        int length =Integer.MAX_VALUE;
        for(String str: strs)
        	length = Math.min(length,str.length());
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i< length; i++){
        	char c = strs[0].charAt(i);
        	for(String str: strs)
        		if(str.charAt(i)!=c)
        			return result.toString();
        	result.append(c);
        }
        return result.toString();
    }
}