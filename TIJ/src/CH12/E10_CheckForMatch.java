package CH12;

/********************** Exercise 10 **********************
 * For the phrase "Java now has regular expressions"
 * evaluate whether the following expressions will find a
 * match:
 *
 *   ^Java
 *   \Breg.*
 *   n.w\s+h(a|i)s
 *   s?
 *   s*
 *   s+
 *   s{4}
 *   s{1}.
 *   s{0,3}
 ********************************************************/
import java.util.regex.*;

public class E10_CheckForMatch {
	public static void main(String[] args) {
		String source = "Java now has regular expressions";
		String[] regEx = { "^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*",
				"s+", "s{4}", "s{1}.", "s{0,3}" };
		System.out.println("Source string: " + source);
		
		for(String pattern: regEx){
			System.out.println("Regular expression: \""+pattern+"\"");
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(source);
			while(m.find()){
				System.out.println("Match \"" + m.group() +
		                 "\" at positions " + m.start() + "-" +
		                 (m.end() - 1));
			}
		}
	}
}
