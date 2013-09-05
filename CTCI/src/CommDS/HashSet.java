package CommDS;
import java.util.*;

/**
 * interface:
 * Set name=new HashSet(101);
 * names.add("Nina");
 * names.remove("Rome");
 * Iterator iter=names.iterator();
 * while(iter.hasNext())
 * {
 * 		System.out.printf(iter.next());
 * }
 * @author heguangliu
 *
 */

public class HashSet extends AbstractSet{
	
	private static Node[] buckets;
	private int size;
	public static final int DEFAULT_SIZE = 997;
	
	public HashSet(){
		buckets= new Node[DEFAULT_SIZE];
	}
	
	public HashSet(int bucketLength){
		buckets = new Node[bucketLength];
	}
	
	public boolean contains(Object x){
		int h = x.hashCode();
		h = Math.abs(h);
		h = h % buckets.length;
		Node current = buckets[h];
		
		while(current != null){
			if(current.data.equals(x))
				return true;
			current = current.next;
		}
		return false;
	}
	
	public boolean add(Object x){
		int h = x.hashCode();
		if(h < 0) h = -h;
		h = h % buckets.length;
		Node current = buckets[h];
		
		while(current!=null){
			if(current.data.equals(x))
				return false;
			current = current.next;
		}
		Node newNode = new Node();
		newNode.data = x;
		newNode.next = buckets[h];
		buckets[h] = newNode;
		size++;
		return true;
	}
	
	public boolean remove(Object x){
		int h = x.hashCode();
		h = Math.abs(h);
		Node current = buckets[h];
		Node previous = null;
		while(current!=null){
			if(current.data.equals(x)){
				if(previous == null)
					buckets[h] = current.next;
				else
					previous.next = current.next;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public Iterator iterator(){
		return new HashSetIterator();
	}
	
	public int size(){
		return size;
	}
	
	static class HashSetIterator implements Iterator{
		private int bucket;
		private Node current;
		private int previousBucket;
		private Node previous;
		
		public HashSetIterator(){
			current = null;
			bucket = -1;
			previous = null;
			previousBucket = -1;
		}
		
		public boolean hasNext(){
			if(current != null && current.next!= null)
				return true;
			for(int b = bucket+1; b < buckets.length; b++){
				if(buckets[b] != null)
					return true;
			}
			return false;
		}
		
		public Object next(){
			previous = current;
			previousBucket = bucket;
			if(current == null || current.next == null){
				bucket++;
				while(bucket < buckets.length && buckets[bucket]==null){
					bucket++;
				}
				if(bucket < buckets.length)
					current = buckets[bucket];
				else
					throw new NoSuchElementException();
			}else{
				current = current.next;
			}
			return current.data;
		}
		
		public void remove(){
			if(previous!=null && previous.next== current){
				previous.next = current.next;
			}else if(previousBucket < bucket){
				buckets[bucket]= current.next;
			}else{
				throw new IllegalStateException();
			}
			current = previous;
			bucket = previousBucket;
		}
	}
	
	class Node{
		public Object data;
		public Node next;
	}
}