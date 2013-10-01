package String;

import java.util.Arrays;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 Note: All inputs will be in lower-case.
 * @author heguangliu
 *
 */
import java.util.*;

public class Anagrams {
	public static ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (strs == null || strs.length == 0)
			return new ArrayList<String>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> result = new ArrayList<String>();
		for (String str : strs) {
			String key = getCharBitMap(str);
			if (map.get(key) == null) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		for (ArrayList<String> list : map.values()) {
			if (list.size() > 1)
				result.addAll(list);
		}
		return result;
	}

	private static String getCharBitMap(String str) {
		char[] array = str.toCharArray();
		int[] result = new int[26];
		for (char c : array) {
			result[c - 'a'] += 1;
		}
		return Arrays.toString(result);
	}
}