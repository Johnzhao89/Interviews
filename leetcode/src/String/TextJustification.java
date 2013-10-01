package String;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified. You should
 * pack your words in a greedy approach; that is, pack as many words as you can
 * in each line. Pad extra spaces ' ' when necessary so that each line has
 * exactly L characters. Extra spaces between words should be distributed as
 * evenly as possible. If the number of spaces on a line do not divide evenly
 * between words, the empty slots on the left will be assigned more spaces than
 * the slots on the right. For the last line of text, it should be left
 * justified and no extra space is inserted between words. For example, words:
 * ["This", "is", "an", "example", "of", "text", "justification."] L: 16. Return
 * the formatted lines as: [ "This    is    an", "example  of text",
 * "justification.  " ] Note: Each word is guaranteed not to exceed L in length.
 * 
 * @author heguangliu
 * 
 */
public class TextJustification {
	public static ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		int start = 0, length = 0;
		for(int i=0; i< words.length ;i++){
			length += words[i].length();
			if((length+i-start)>L){
				result.add(formString(start, i-1, words, length-words[i].length(), L));
				length = words[i].length();
				start = i;
			}
		}
		if(length >0){
			result.add(formString(start, words.length -1, words, length, L));
		}
		if(result.size()==0)
			result.add(getSpace(L));
		return result;
	}

	public static String formString(int start, int end, String[] words, int length,
			int L) {
		StringBuilder sb = new StringBuilder();
		if (end == words.length - 1 || start == end) {
			while (start < end) {
				sb.append(words[start++] + getSpace(1));
			}
			sb.append(words[end]);
			sb.append(getSpace(L - sb.length()));
		} else {
			int space = (L - length) / (end - start);
			int extra = (L- length)%(end - start);
			while (start < end) {
				sb.append(words[start++]+getSpace(space));
				if(extra>0){
					sb.append(getSpace(1));
					extra--;
				}
			}
			sb.append(words[end]);
		}
		return sb.toString();
	}

	public static String getSpace(int n) {
		if (n == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(' ');
			n--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println();
	}
}