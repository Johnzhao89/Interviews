package CH12;
/************************** Exercise 12 ******************
 * Modify Groups.java to count all unique words
 * with no initial capital letter.
 *********************************************************/
import java.util.*;
import java.util.regex.*;

public class E12_Groups2{
	public static void main(String[] args){
		Set<String> words= new HashSet<String>();
		Matcher m = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(Groups.POEM);
		
		while(m.find())
			words.add(m.group(1));
		
	}
}


