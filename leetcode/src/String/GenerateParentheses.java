package String;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:
 "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author heguangliu
 *
 */
import java.util.*;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		if (n <= 0)
			return result;
		generateParenthesis(n, n, new StringBuilder(), result);
		return result;
	}

	private void generateParenthesis(int leftRemain, int rightRemain,
			StringBuilder sb, ArrayList<String> result) {
		if (leftRemain == 0 && rightRemain == 0) {
			result.add(sb.toString());
			return;
		}
		int len = sb.length();
		if (leftRemain <= rightRemain) {
			if (leftRemain > 0) {
				sb.append('(');
				generateParenthesis(leftRemain - 1, rightRemain, sb, result);
			}
		}
		if (leftRemain < rightRemain) {
			sb.delete(len, sb.length());// be caution!
			sb.append(')');
			generateParenthesis(leftRemain, rightRemain - 1, sb, result);
		}
	}
}