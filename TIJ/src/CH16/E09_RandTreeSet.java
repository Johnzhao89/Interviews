package CH16;
/****************** Exercise 9 *****************
 * Use RandomGenerator.String to fill a TreeSet,
 * but use alphabetic ordering. Print the TreeSet
 * to verify the sort order.
 ***********************************************/
import java.util.*;

public class E09_RandTreeSet{
	public static void main(String[] args){
		TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		ts.addAll(Countries.names(10));
		System.out.println("ts = " + ts);
	}
}

