package String;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.
Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 * @author heguangliu
 *
 */
import java.util.*;
public class SimplifyPath{
	public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(path == null || path.charAt(0)!='/')
        	return null;
        String[] splits = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String split: splits){
        	if(split.equals("..") && !stack.isEmpty())
        		stack.pop();
        	else if(!split.equals(".") && !split.isEmpty() && !split.equals(".."))
        		stack.push(split);
        }
        if(stack.isEmpty())
        	return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	sb.insert(0, "/"+stack.pop());
        }
        return sb.toString();
	}
}