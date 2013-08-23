package CH16;
/****************** Exercise 14 *****************
 * Show that java.util.Properties works in the above
 * program (containers/Maps.java from the book).
 ***********************************************/

import java.util.*;
public class E14_PropertiesDemo{
	static void printKeys(Map<Object,Object> map){
		System.out.println("Size ="+map.size()+", ");
		System.out.println("Keys: ");
		System.out.println(map.keySet());
	}
	
	static void test(Map<Object,Object> map){
		System.out.println(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(25));
		map.putAll(new CountingMapData(25));
		printKeys(map);
		System.out.println(map);
		System.out.println("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(11): "+map.containsKey(11));
		System.out.println("map.get(11): "+map.get(11));
		Object key= map.keySet().iterator().next();
		System.out.println("First key in map: "+ key);
		map.remove(key);
		printKeys(map);
		map.clear();
		System.out.println("map.isEmpty()"+map.isEmpty());
		map.putAll(new CountingMapData(25));
		map.keySet().removeAll(map.keySet());
		System.out.println("map.isEmpty(): "+map.isEmpty());
	}
	public static void main(String[] args){
		test(new Properties());
	}
}