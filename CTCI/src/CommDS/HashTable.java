package CommDS;
import java.util.*;
/**
 * 
 * @author heguangliu
 *
 */
public class HashTable{
	private int hashSize;
	private int entrySize;
	private Node[] buckets;
	public static final int HASH_SIZE = 31;
	
	public HashTable(){
		hashSize = HASH_SIZE;
		entrySize= 0;
		buckets= new Node[hashSize];
	}
	
	public HashTable(int hSize){
		hashSize = hSize;
		entrySize= 0;
		buckets= new Node[hashSize];
	}
	
	public Node lookup(String key){
		int h = key.hashCode();
		h = Math.abs(h);
		h = h % buckets.length;
		Node current = buckets[h];
		
		while(current!=null){
			if(current.key.equals(key))
				return current;
		}
		return null;
	}
	
	public boolean remove(String key){
		int h = key.hashCode();
		h = Math.abs(h);
		h = h % buckets.length;
		Node prev = null;
		Node curr;
		for(curr = buckets[h]; curr!=null; curr = curr.next){
			if(curr.key.equals(key)){
				if(prev == null){
					buckets[h] = curr.next;
				}else{
					prev.next = curr.next;
				}
				entrySize--;
				return true;
			}
			prev = curr;
		}
		return false;
	}
	
	public boolean insert(String key, Object data){
		int h = key.hashCode();
		h = Math.abs(h)% buckets.length;
		Node curr;
		for(curr = buckets[h]; curr!=null; curr=curr.next){
			if(curr.key==key)
				return false;
		}
		Node newNode = new Node(key, data, buckets[h]);
		buckets[h] = newNode;
		entrySize++;
		return true;
	}
	
	public int getEntryNum(String key){
		return entrySize;
	}
	
	public void printAll(){
		for(int i =0; i<hashSize; i++){
			if(buckets[i]!=null){
				printList(buckets[i]);
			}
		}
	}
	
	public void hashState(){
		int nonEmptySize =0;
		int longestChain = 0;
		for(int i=0; i<hashSize; i++){
			if(buckets[i] != null){
				nonEmptySize++;
				Node curr;
				int count ;
				for(count =0,curr=buckets[i]; curr!=null;count++,curr=curr.next){
					if(count>longestChain){
						longestChain = count;
					}
				}
			}
		}
	}
	
	public void printList(Node list){
		if(list == null)
			return;
		for(Node n=list; n!=null; n=n.next){
			System.out.println("Name: "+n.key+"; Sorce: "+n.value);
		}
	}
	
	
	class Node{
		String key;
		Object value;
		Node next;
		Node(String key, Object value){
			this.key = key;
			this.value = value;
		}
		Node(String key, Object value, Node next){
			this.key = key;
			this.value = value;
			this.next =next;
		}
	}
}