package CH15;

/****************** Exercise 20 *****************
 * Demonstrate deepEquals() for multidimensional
 * arrays.
 ************************************************/

import java.util.*;

public class E20_ArrayDeepEquals {
	public static void main(String[] args) {
		int[][] table1 = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 10 } };
		int[][] table2 = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 10 } };
		Integer[][] table3 = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 10 } };
		int[][] table4 = { { 1, 2, 3 }, { 6, 5, 4 }, { 7, 8 } };
		System.out.println(Arrays.deepEquals(table1, table2));
		System.out.println(Arrays.deepEquals(table1, table3));
		System.out.println(Arrays.deepEquals(table1, table4));
	}
}