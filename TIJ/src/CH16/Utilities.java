package CH16;

import java.util.*;

public class Utilities {
	static List<String> list = Arrays.asList("one Two three Four five six one"
			.split(" "));

	public static void main(String[] args) {
		System.out.println(list);
		System.out
				.println("list disjoint (Four)? "
						+ Collections.disjoint(list,
								Collections.singletonList("Four")));
		System.out.println("max: " + Collections.max(list));
		System.out.println("min: " + Collections.min(list));
		System.out.println("max comparator: "
				+ Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		System.out.println("min comparator: "
				+ Collections.min(list, String.CASE_INSENSITIVE_ORDER));
		List<String> sublist = Arrays.asList("Four five six".split(" "));
		System.out.println("index f sublist: "
				+ Collections.indexOfSubList(list, sublist));
		System.out.println("lastindexOfSubList"
				+ Collections.lastIndexOfSubList(list, sublist));
		Collections.reverse(list);
		Collections.replaceAll(list, "one", "Yo");
		Collections.rotate(list, 3);
		List<String> source = Arrays.asList("in the matrix".split(" "));
		Collections.copy(list, source);
		Collections.swap(list, 0, list.size() - 1);
		Collections.shuffle(list, new Random(47));
		Collections.fill(list, "pop");
		Collections.frequency(list, "pop");
		List<String> dups = Collections.nCopies(3, "snap");
		System.out.println(dups);

		Enumeration<String> e = Collections.enumeration(dups);
		Vector<String> v = new Vector<String>();
		while (e.hasMoreElements())
			v.addElement(e.nextElement());
		ArrayList<String> arrayList = Collections.list(v.elements());

	}
}