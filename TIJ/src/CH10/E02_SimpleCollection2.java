package CH10;
/****************** Exercise 2 ******************
 * Modify SimpleCollection.java to use a Set for c.
 ***********************************************/
import java.util.*;

public class E02_SimpleCollection2{
	public static void main(String[] args){
		Collection<Integer> c = new HashSet<Integer>();
		for(int i = 0; i<10; i++)
			c.add(i);
		for(Integer i:c)
			System.out.print(i+" ");
	}
}
