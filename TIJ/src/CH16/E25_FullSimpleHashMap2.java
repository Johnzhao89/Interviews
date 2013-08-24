package CH16;
/****************** Exercise 25 *****************
 * Instead of using a ListIterator for each bucket,
 * modify MapEntry so it is a self-contained
 * singly-linked list (each MapEntry should have a
 * forward link to the next MapEntry). Modify the
 * rest of the code in SimpleHashMap.java so
 * this new approach works correctly.
 ***********************************************/
import java.util.*;

class SimpleHashMap5<K,V> extends AbstractMap<K,V>{
	static class Entry<K,V> implements Map.Entry<K, V>{
		private K key;
		private V value;
		Entry<K,V> next;
		public Entry(K key, V value){
			this.key= key;
			this.value= value;
		}
		public K getKey(){
			return key;
		}
		public V getValue(){
			return value;
		}
		public V setValue(V v){
			V result=value;
			value = v;
			return result;
		}
		public int hashCode(){
			return key.hashCode() ^ (value == null ? 0 : value.hashCode());
		}
		public boolean equals(Object o){
			if(o instanceof Entry){
				Entry<K,V> e =(Entry<K,V>)o;
				Object key1 = getKey();
				Object key2 = e.getKey();
				if(key1.equals(key2)){
					Object val1 = getValue();
					Object val2 = e.getValue();
					return val1==null? val2 ==null:val1.equals(val2);
				}
			}
			return false;
		}
		public String toString(){
			return key + "=" + value;
		}
	}
		static final int SIZE =997;
		Entry<K,V>[] buckets = new Entry[SIZE];
		
		public V put(K key, V value){
			V oldValue = null;
			int index =Math.abs(key.hashCode())%SIZE;
			Entry<K,V> newPair = new Entry<K,V>(key,value);
			
			if(buckets[index]==null)
				buckets[index]=newPair;
			Entry<K,V> prevPair = null;
			boolean found = false;
			for(Entry<K,V> pair= buckets[index]; pair!=null; pair= pair.next){
				if(pair.getKey().equals(key)){
					oldValue = pair.getValue();
					if(prevPair!=null)
						prevPair.next = newPair;
					else
						buckets[index] = newPair;
					newPair.next=pair.next;
					found= true;
					break;
				}
				prevPair=pair;
			}
			if(!found)
				prevPair.next = newPair;
			return oldValue;
		}
		
		public V get(Object key){
			int index = Math.abs(key.hashCode())%SIZE;
			for(Entry<K,V> pair = buckets[index]; pair !=null; pair = pair.next)
				if(pair.getKey().equals(key))
					return pair.getValue();
			return null;
		}
		
		public Set<Map.Entry<K,V>> entrySet(){
			Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
			for(Entry<K,V> bucket : buckets){
				for(Entry<K,V> pair = bucket;pair !=null; pair=pair.next)
					set.add(pair);
			}
			return set;
		}
		
		public void clear(){
			buckets = new Entry[SIZE];
		}
		
		public V remove(Object key){
			int index = Math.abs(key.hashCode())%SIZE;
			Entry<K,V> prevPair = null;
			for(Entry<K,V> pair = buckets[index]; pair!= null;pair= pair.next){
				if(pair.getKey().equals(key)){
					V value = pair.getValue();
					if(prevPair!=null)
						prevPair.next = pair.next;
					else
						buckets[index] = null;
					return value;
				}
			}
			return null;
		}
		
		public int size(){
			int sz = 0;
			for(Entry<K,V> bucket:buckets)
				for(Entry<K,V> pair = bucket; pair!=null;pair=pair.next)
					sz++;
			return sz;
		}
		
		public boolean isEmpty(){
			for(Entry<K,V> bucket: buckets)
				if(bucket!=null)
					return false;
			return true;
		}
		
		public boolean containsKey(Object key){
			for(Entry<K,V> bucket:buckets){
				for(Entry<K,V> pair= bucket; pair!=null; pair=pair.next){
				if(pair.getKey().equals(key))
					return true;
				}
			}
			return false;
	}
}

public class E25_FullSimpleHashMap2{
	public static void main(String[] args){
		SimpleHashMap5<String,String> 
		m =new SimpleHashMap5<String,String>(),
				m2 = new SimpleHashMap5<String,String>();
		m.putAll(Countries.capitals(10));
		m2.putAll(Countries.capitals(10));
		System.out.println("m.size() = "+m.size());
		System.out.println("m.isEmpty() = "+m.isEmpty());
		System.out.println("m.equals(m2) = "+m.equals(m2));
		System.out.println("m.containsKey(\"BENIN\") = " +
	               m.containsKey("BENIN"));
		System.out.println("m.containsKey(\"MARS\") = " +
	               m.containsKey("MARS"));
		System.out.println("m.keySet() = " + m.keySet());
		System.out.println("m.values() = " + m.values());
		m.remove("ALGERIA");
	}
}




