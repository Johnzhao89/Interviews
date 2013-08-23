package CH16;
/****************** Exercise 12 *****************
 * Substitute a HashMap, a TreeMap, and a LinkedHashMap
 * in AssociativeArray.java's main().
 ***********************************************/
import java.util.*;

public class E12_MapsDemo{
	private static void test(Map<String,String> map){
		map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try{
        	map.put("extra", "object");
        }catch(ArrayIndexOutOfBoundsException e){
        	System.out.println("Too many!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
	}
	public static void main(String[] args){
		test(new HashMap<String,String>());
		test(new TreeMap<String,String>());
		test(new LinkedHashMap<String,String>());
	}
}


