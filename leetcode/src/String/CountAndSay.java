package String;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.
 Note: The sequence of integers will be represented as a string.
 * @author heguangliu
 *
 */
import java.util.*;

public class CountAndSay {
	public static String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0)
			return null;
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		for (int i = 0; i < n-1; i++) {
			list.add(getNext(list));
		}
		return list.get(list.size()-1);
	}

	public static String getNext(ArrayList<String> list) {
		String str = list.get(list.size() - 1);
		StringBuilder sb = new StringBuilder();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				sb.append(String.valueOf(count)+last);
				last = str.charAt(i);
				count = 1;
			}
		}
		sb.append(String.valueOf(count)+last);
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(countAndSay(10));
	}
}