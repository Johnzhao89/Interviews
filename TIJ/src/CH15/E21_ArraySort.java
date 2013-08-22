package CH15;

/****************** Exercise 21 *****************
 * Try to sort an array of the objects in Exercise
 * 18. Implement Comparable to fix the problem. Now
 * create a Comparator to sort the objects into reverse
 * order.
 ************************************************/
import java.util.*;
import java.lang.reflect.*;

class ComparableBerylliumSphere extends BerylliumSphere implements
		Comparable<BerylliumSphere> {
	static long getID(BerylliumSphere bs) {
		try {
			Field fid = BerylliumSphere.class.getDeclaredField("id");
			fid.setAccessible(true);
			return fid.getLong(bs);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
	}

	public int compareTo(BerylliumSphere rv) {
		long id = getID(this);
		long rvid = getID(rv);
		return (id < rvid ? -1 : (id == rvid ? 0 : 1));
	}
}

public class E21_ArraySort {
	public static void main(String[] args) {
		Random r = new Random(47);
		BerylliumSphere[] a = new BerylliumSphere[5];
		for (int i = 0; i < a.length; i++)
			a[i] = new ComparableBerylliumSphere();
		Collections.shuffle(Arrays.asList(a), r);
		System.out.println("Before sort 2: a = " + Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("After sort 2: a = " + Arrays.toString(a));
		Collections.shuffle(Arrays.asList(a), r);
		System.out.println("Before rev. sort 3: a = " + Arrays.toString(a));
		Arrays.sort(a, Collections.reverseOrder());
		System.out.println("After rev. sort 3: a = " + Arrays.toString(a));
	}
}
