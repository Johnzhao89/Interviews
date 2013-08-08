package CH10;
/******************* Exercise 24 **************************
 * Fill a LinkedHashMap with String keys and objects.
 * Extract the pairs, sort them based on the keys, and
 * re-insert them into the Map.
 *********************************************************/
import java.util.*;

public class E24_MapOrder2{
	public static void main(String[] args){
		Map<String, String> m1= new LinkedHashMap<String,String>();
		m1.put("ALGERIA","Algiers");
		m1.put("ANGOLA","Luanda");
		m1.put("BENIN","Porto-Novo");
		System.out.println(m1);
		String[] keys = m1.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		
		Map<String,String> m2= new LinkedHashMap<String,String>();
		for(String key:keys)
			m2.put(key, m1.get(key));
	}
}

