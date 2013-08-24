package CH16;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/****************** Exercise 23 *****************
 * Implement the rest of the Map interface for
 * SimpleHashMap.
 ***********************************************/


class SimpleHashMap4<K, V> extends AbstractMap<K, V> {

	static final int SIZE = 997;
	LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

	public void clear() {
		buckets = new LinkedList[SIZE];
	}

	public V remove(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			return null;
		Iterator<MapEntry<K, V>> it = buckets[index].iterator();
		while (it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			if (iPair.getKey().equals(key)) {
				V value = iPair.getValue();
				it.remove();
				return value;
			}
		}
		return null;
	}

	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K, V>>();

		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		boolean found = false;

		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		while (it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				break;
			}
		}
		if (!found)
			buckets[index].add(pair);
		return oldValue;
	}

	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			return null;
		for (MapEntry<K, V> iPair : buckets[index])
			if (iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null)
				continue;
			for (MapEntry<K, V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}
	
	public int size(){
		int sz = 0;
		for(LinkedList<MapEntry<K,V>> bucket: buckets)
			if(bucket!=null)
				sz+= bucket.size();
		return sz;
	}
	
	public boolean isEmpty(){
		for(LinkedList<MapEntry<K,V>> bucket: buckets)
			if(bucket!=null)
				return false;
		return true;
	}
	
	public boolean containsKey(Object key){
		for(LinkedList<MapEntry<K,V>>bucket: buckets){
			if(bucket == null) 
				continue;
			for(MapEntry<K,V> mPair: bucket)
				if(mPair.getKey().equals(key))
					return true;
		}
		return false;
	}
}

public class E23_FullSimpleHashMap {
	  public static void main(String args[]) {
	    SimpleHashMap4<String,String>
	      m = new SimpleHashMap4<String,String>(),
	      m2 = new SimpleHashMap4<String,String>();
	    m.putAll(Countries.capitals(10));
	    m2.putAll(Countries.capitals(10));
	    System.out.println("m.size() = " + m.size());
	    System.out.println("m.isEmpty() = " + m.isEmpty());
	    System.out.println("m.equals(m2) = " + m.equals(m2));
	    System.out.println("m.containsKey(\"BENIN\") = " +
	      m.containsKey("BENIN"));
	    System.out.println("m.containsKey(\"MARS\") = " +
	      m.containsKey("MARS"));
	    System.out.println("m.keySet() = " + m.keySet());
	    System.out.println("m.values() = " + m.values());
	}
	}
