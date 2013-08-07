package CH10;

import java.util.*;
public class ListFeatures{
	public static void main(String[] args){
		Random rand = new Random(47);
		List<Integer> pets = new ArrayList<Integer>(7);
		Collections.addAll(pets,1,2,3,4,5,6,7);
		System.out.println(pets);
		Integer ref=new Integer(8);
		
		pets.add(ref);
		pets.remove(ref);
		System.out.println(pets);
		
		Integer p = pets.get(2);
		pets.add(3,new Integer(20));
		System.out.println(pets);
		
		List<Integer> sub= pets.subList(1,4);
		Collections.sort(sub);
		System.out.println("sorted subList: " + sub);
		System.out.println(pets.containsAll(sub));
		
		List<Integer> copy = new ArrayList<Integer>(pets);
	    sub = Arrays.asList(pets.get(1), pets.get(4),10,20,3);
	    copy.retainAll(sub);
	    System.out.println("sorted subList: " + sub);
		System.out.println(copy);
		
		copy = new ArrayList<Integer>(pets); 
		System.out.println(copy);
		copy.remove(2);
		System.out.println(copy);
		copy.removeAll(sub);
		System.out.println(copy);
		copy.set(1, new Integer(100));
		System.out.println(copy);
		copy.addAll(2, sub);
		pets.clear();
		System.out.println(copy);
		pets.addAll(new ArrayList(sub));
		System.out.println(pets);
		Object[] o = pets.toArray();
	}
}

