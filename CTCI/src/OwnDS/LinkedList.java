package OwnDS;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList{
	private Node first;
	public LinkedList(){
		first=null;
	}
	public Object getFirst(){
		if(first == null)
			throw new NoSuchElementException();
		return first.data;
	}
	public Object removeFirst(){
		if(first == null)
			throw new NoSuchElementException();
		Object element = first.data;
		first = first.next;
		return element;
	}
	public void addFirst(Object element){
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}
	public ListIterator listIterator(){
		return new LinkedListIterator();
	}
	class Node{
		public Object data;
		public Node next;
	}
	class LinkedListIterator implements ListIterator{
		private Node position;
		private Node previous;
		public LinkedListIterator(){
			position = null;
			previous = null;
		}
		public Object next(){
			if(!hasNext())
				throw new NoSuchElementException();
			previous = position;
			if(position == null)
				position = first;
			else
				position = position.next;
			return position.data;
		}
		public boolean hasNext(){
			if(position == null)
				return first!= null;
			else
				return position.next!=null;
		}
		public void add(Object element){
			if(position == null){
				addFirst(element);
				position = first;
			}else{
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			previous = position;
		}
		public void remove(){
			if(previous == position)
				throw new IllegalStateException();
			if(position == first){
				removeFirst();
			}else{
				previous.next = position.next;
			}
			position = previous;
		}
		public void set(Object element){
			if(position == null)
				throw new NoSuchElementException();
			position.data = element;
		}
		
		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
