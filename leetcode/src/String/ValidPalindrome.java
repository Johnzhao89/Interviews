package String;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
 * @author heguangliu
 *
 */
import java.util.*;
public class ValidPalindrome{
	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.isEmpty())
        	return true;
        int left =0, right = s.length()-1;
        while(left< right){
        	char c1 = s.charAt(left);
        	if(!isLetter(c1)){
        		left++; 
        		continue;
        	}
        	char c2 = s.charAt(right);
        	if(!isLetter(c2)){
        		right--;
        		continue;
        	}
        	if(Character.toLowerCase(c1)!=Character.toLowerCase(c2))
        		return false;
        	left++;
        	right++;
        }
        return true;
    }
	private boolean isLetter(char c){
		return (c>='a' && c<='z')||(c>='A' && c<='Z');
	}
}