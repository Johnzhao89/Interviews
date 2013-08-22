package CH16;

/****************** Exercise 1 ******************
 * Create a List (try both ArrayList and LinkedList)
 * and fill it using Countries. Sort the list and
 * print it, then apply Collections.shuffle() to the
 * list repeatedly, printing it each time so you
 * can see how the shuffle() method randomizes the
 * list differently each time.
 ************************************************/
import java.util.*;

public class E01_CountryList {
	private static Random rnd = new Random(47);

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(Countries.names(8));
		Collections.sort(l);
		System.out.println("sorted: " + l);
		Collections.sort(l, Collections.reverseOrder());
		System.out.println("reversed: " + l);
		for (int i = 1; i < 5; i++) {
			Collections.shuffle(l, rnd);
			System.out.println("shuffled (" + i + "): " + l);
		}
	}
}
