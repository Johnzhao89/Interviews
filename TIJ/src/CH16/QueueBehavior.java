package CH16;

import java.util.*;
import java.util.concurrent.*;

public class QueueBehavior{
	private static int count =10;
	static <T> void test(Queue<T> queue, Generator<T> gen){
		for(int i=0; i<count; i++)
			queue.offer(gen.next());
		
		while(queue.peek()!=null)
			System.out.println(queue.remove()+" ");
		
		System.out.println();
	}
	
	static class Gen implements Generator<String>{
		String[] s = ("one two three four five six seven " +
		          "eight nine ten").split(" ");
		int i;
		public String next(){
			return s[i++];
		}
	}
	public void main(String[] args){
		test(new LinkedList<String>(), new Gen());
	    test(new PriorityQueue<String>(), new Gen());
	    test(new ArrayBlockingQueue<String>(count), new Gen());
	    test(new ConcurrentLinkedQueue<String>(), new Gen());
	    test(new LinkedBlockingQueue<String>(), new Gen());
	    test(new PriorityBlockingQueue<String>(), new Gen());
	}

}

