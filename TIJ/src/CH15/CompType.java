package CH15;

import java.util.*;

public class CompType implements Comparable<CompType> {
	int i;
	int j;
	private static int count = 1;
	private static Random r = new Random(47);

	public CompType(int n1, int n2) {
		i = n1;
		j = n2;
	}

	public String toString() {
		String result = "[i = " + i + ", j = " + j + "]";
		if (count++ % 3 == 0)
			result += "\n";
		return result;
	}

	public int compareTo(CompType arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Generator<CompType> generator() {
		return new Generator<CompType>() {
			public CompType next() {
				return new CompType(r.nextInt(100), r.nextInt(100));
			}
		};
	}
	
	
	public static void main(String[] args) {
		CompType[] a = new CompType[12];
		for(int i=0; i<12; i++)
			a[i]=generator().next();
	    System.out.println("before sorting:");
	    System.out.println(Arrays.toString(a));
	    Arrays.sort(a);
	    System.out.println("after sorting:");
	    System.out.println(Arrays.toString(a));
	    
	    Arrays.sort(a, Collections.reverseOrder());
	    System.out.println("after reversing:");
	    System.out.println(Arrays.toString(a));
	  }
	
	

}
