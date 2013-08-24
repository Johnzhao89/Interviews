package CH16;

/****************** Exercise 16 *****************
 * Apply the tests in Maps.java to SlowMap to
 * verify that it works. Fix anything in SlowMap
 * that doesn't work correctly.
 ***********************************************/
import java.util.*;

class SlowMap2<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

	public V put(K key, V value) {
		if (key == null)
			throw new NullPointerException();
		V oldValue = get(key);
		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else {
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}

	public V get(Object key) {
		if (key == null)
			throw new NullPointerException();
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	private EntrySet entrySet = new EntrySet();

	public Set<Map.Entry<K, V>> entrySet() {
		return entrySet();
	}

	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K, V>>() {
				private int index = -1;
				boolean canRemove;

				public boolean hasNext() {
					return index < keys.size() - 1;
				}

				public Map.Entry<K, V> next() {
					canRemove = true;
					++index;
					return new MapEntry<K, V>(keys.get(index),
							values.get(index));
				}

				public void remove() {
					if (!canRemove)
						throw new IllegalStateException();
					canRemove = false;
					keys.remove(index);
					values.remove(index--);
				}
			};
		}

		public boolean contains(Object o) {
			if (o instanceof MapEntry) {
				MapEntry<K, V> e = (MapEntry<K, V>) o;
				K key = e.getKey();
				if (keys.contains(key))
					return e.equals(new MapEntry<K, V>(key, get(key)));
			}
			return false;
		}

		public boolean remove(Object o) {
			if (contains(o)) {
				MapEntry<K, V> e = (MapEntry<K, V>) o;
				K key = e.getKey();
				V val = e.getValue();
				keys.remove(key);
				values.remove(val);
				return true;
			}
			return false;
		}

		@Override
		public int size() {
			return keys.size();
		}

		@Override
		public void clear() {
			keys.clear();
			values.clear();
		}
	}
}

public class E16_SlowMapTest {
	public static void printKeys(Map<Integer, String> map) {
		System.out.println("Size = " + map.size() + ", ");
		System.out.println("Keys: ");
		System.out.println(map.keySet()); // Produce a Set of the keys
	}

	public static void test(Map<Integer, String> map) {
		System.out.println(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(25));
		// Map has 'Set' behavior for keys:
		map.putAll(new CountingMapData(25));
		printKeys(map);
		// Producing a Collection of the values:
		System.out.println("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(11): " + map.containsKey(11));
		System.out.println("map.get(11): " + map.get(11));
		System.out.println("map.containsValue(\"F0\"): "
				+ map.containsValue("F0"));
		Integer key = map.keySet().iterator().next();
		System.out.println("First key in map: " + key);
		map.remove(key);
		printKeys(map);
		map.clear();
		System.out.println("map.isEmpty(): " + map.isEmpty());
		map.putAll(new CountingMapData(25));
		// Operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		System.out.println("map.isEmpty(): " + map.isEmpty());
	}

	public static void main(String[] args) {
		System.out.println("Testing SlowMap");
		test(new SlowMap<Integer, String>());
		System.out.println("Testing SlowMap2");
		test(new SlowMap2<Integer, String>());
	}
}
