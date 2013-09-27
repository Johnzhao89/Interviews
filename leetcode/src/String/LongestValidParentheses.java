package String;
/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * @author heguangliu
 *
 */
import java.util.*;

public class LongestValidParentheses{
	
	public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.isEmpty())
        	return 0;
        int maxLen = 0, last =-1;
        Stack<Integer> lefts = new Stack<Integer>();
        for(int i=0; i< s.length(); i++){
        	if(s.charAt(i)=='('){
        		lefts.push(i);
        	}else{
        		if(lefts.isEmpty()){
        			last = i;
        		}else{
        			lefts.pop();
        			if(lefts.isEmpty()){
        				maxLen = Math.max(maxLen, i-last); 
        			}else{
        				maxLen = Math.max(maxLen, i-lefts.peek());//good idea
        			}
        		}
        	}
        }
        return maxLen;
    }
}