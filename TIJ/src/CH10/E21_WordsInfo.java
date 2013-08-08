package CH10;

/****************** Exercise 21 *****************
 * Using a Map<String,Integer>, follow the form of
 * UniqueWords.java to create a program that counts
 * the occurrence of words in a file. Sort the
 * results using Collections.sort() with a second
 * argument of String.CASE_INSENSITIVE_ORDER (to
 * produce an alphabetic sort), and display the result.
 ***********************************************/

import java.util.*;

public class E21_WordsInfo {
	public static void main(String[] args) {
		Map<String, Integer> wordsStat = new HashMap<String, Integer>();
		for (String word : new String[5]) {
			Integer freq = wordsStat.get(word);
			wordsStat.put(word, freq == null ? 1 : freq + 1);
		}
		List<String> keys = new ArrayList<String>(wordsStat.keySet());
		Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
		for (String key : keys)
			System.out.println(key + " => " + wordsStat.get(key));

	}
}
