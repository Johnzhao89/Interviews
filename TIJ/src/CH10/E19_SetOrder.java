package CH10;
/******************* Exercise 19 *****************
 * Repeat Exercise 18 with a HashSet and
 * LinkedHashSet.
 *************************************************/
import java.util.*;

public class E19_SetOrder{
	public static void main(String[] args){
		Set<String> s1= new HashSet<String>();
		System.out.println(s1);
		String[] elements = s1.toArray(new String[0]);
		Arrays.sort(elements);
		
		Set<String> s2 = new LinkedHashSet<String>();
		for(String element: elements)
			s2.add(element);
		System.out.println(s2);
	}
}

