package CH12;

/************************** Exercise 11 ******************
 *Apply the regular expression
 *     (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
 *    to
 *   "Arline ate eight apples and one orange while Anita
 *    hadn't any"
 *********************************************************/
import java.util.regex.*;

public class E11_CheckForMatch2 {
	public static void main(String[] args) {
		String resource = "Arline ate eight apples and "
				+ "one orange while Anita hadn't any";
		Pattern p = Pattern
				.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
		Matcher m = p.matcher(resource);
		while (m.find()) {
			System.out.println("Match \"" + m.group() + "\" at positions "
					+ m.start() + "-" + (m.end() - 1));
		}
	}
}
