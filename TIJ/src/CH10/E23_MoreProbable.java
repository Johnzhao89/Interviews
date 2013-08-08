package CH10;
/****************** Exercise 23 *****************
 * Starting with Statistics.java, create a
 * program that runs the test repeatedly and
 * looks to see if any one number tends to appear
 * more than the others in the results.
 ***********************************************/

import java.util.*;
import java.util.Map.Entry;

class Counter{
	int i =1;
	public String toString(){
		return Integer.toString(i);
	}
}

class HistoUnit implements Comparable<HistoUnit>{
	Counter counter;
	Integer val;
	public HistoUnit(Counter counter, Integer val){
		this.counter= counter;
		this.val = val;
	}
	
	public int compareTo(HistoUnit o){
		int lv = o.counter.i;
		int rv = counter.i;
		return (lv < rv? -1:(lv== rv? 0:1));
	}
	public String toString(){
		return "Value = "+val+", Occurrences ="+counter.i+"\n";
	}
}
//build a freq map first, then move it to another class list, sort by the freq
public class E23_MoreProbable{
	private static Random rand = new Random(47);
	public static void main(String[] args){
		Map<Integer, Counter> m=
				new HashMap<Integer, Counter>();
		
		for(int i=0; i<100000; i++){
			int r = rand.nextInt(100);
			if(m.containsKey(r))
				m.get(r).i++;
			else
				m.put(r,new Counter());
		}
		
		List<HistoUnit> lst = new ArrayList<HistoUnit>();
		Iterator<Entry<Integer, Counter>> it = m.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, Counter> entry = it.next();
			lst.add(new HistoUnit(entry.getValue(),entry.getKey()));
		}
		Collections.sort(lst);
		System.out.println("lst = "+lst);
		
	}
}



