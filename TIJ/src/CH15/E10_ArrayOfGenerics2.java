package CH15;

/****************** Exercise 10 *****************
 * Modify ArrayOfGenerics.java to use containers
 * instead of arrays. Show that you can eliminate
 * the compile-time warnings.
 ************************************************/
import java.util.*;

public class E10_ArrayOfGenerics2 {
	public static void main(String[] args) {
		ArrayList<List<String>> ls = new ArrayList<List<String>>();
		ls.add(new ArrayList<String>());
		ls.get(0).add("Array of Generics");
		System.out.println(ls.toString());
	}
}