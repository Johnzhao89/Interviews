package String;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example, 
Given s = "Hello World",
return 5.
 * @author heguangliu
 *
 */
public class LengthOfLastWord{
	public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.isEmpty())
        	return 0;
        int j = s.length()-1;
        while(s.charAt(j)==' ' && j>0){
        	j--;
        }
        for(int i=j; i>=0; i--){
        	if(s.charAt(i)==' '){
        		return j-i;
        	}
        }
        return j+1;
    }
}