package String;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 * @author heguangliu
 *
 */
import java.util.*;

public class LetterCombinationOfPhoneNumber {
	public ArrayList<String> letterCombinations2(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null)
			return result;
		String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
				"wxyz" };
		ArrayList<StringBuilder> builders = new ArrayList<StringBuilder>();
		ArrayList<String> results = new ArrayList<String>();

		for (int i = 0; i < digits.length(); i++) {
			int d = digits.charAt(i) - '2';
			if (d < 0 || d > 7)
				return results;
			if (builders.isEmpty()) {
				for (int k = 0; k < letters[d].length(); k++) {
					StringBuilder sb = new StringBuilder();
					sb.append(letters[d].charAt(k));
					builders.add(sb);
				}
				continue;
			}
			int curSize = builders.size();
			for (int j = 0; j < curSize; j++) {
				StringBuilder sb = builders.get(j);
				for (int k = 0; k < letters[d].length(); k++) {
					if (k == letters[d].length() - 1) {
						sb.append(letters[d].charAt(k));
					} else {
						StringBuilder ss = new StringBuilder(sb.toString());
						ss.append(letters[d].charAt(k));
						builders.add(ss);
					}
				}
			}
		}
		for (StringBuilder sb : builders)
			results.add(sb.toString());
		if (results.size() == 0)
			results.add("");

		return results;
	}
	
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> results = new ArrayList<String>();
		if (digits == null)
			return results;
		String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
				"wxyz" };
		for(int i =0;i<digits.length(); i++){
			int d = digits.charAt(i)-'2';
			if(d < 0 || d > 7)
				return results;
			int curSize = results.size();
			if(curSize == 0){
				for(int k =0; k< letters[d].length(); k++){
					results.add(new String(""+letters[d].charAt(k)));
				}
			}
			for(int j =0; j< curSize; j++){
				String s = results.get(j);
				for(int k=0; k< letters[d].length(); k++){
					if(k == letters[d].length()-1){
						results.set(j,s+letters[d].charAt(k));
					}else{
					results.add(new String(s+letters[d].charAt(k)));
					}
				}
			}
		}
		if(results.size() == 0)
			results.add("");
		return results;
	}
}