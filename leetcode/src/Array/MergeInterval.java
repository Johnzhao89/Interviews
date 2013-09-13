package Array;

/*
 * 
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

import java.util.*;

class Interval{
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class MergeInterval{
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(intervals==null||intervals.size()==0)
			return new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2){
				return (o1.start - o2.start);
			}});
		ArrayList<Interval> result = new ArrayList<Interval>();
		result.add(intervals.get(0));
		for(int i=1; i< intervals.size(); i++){
			Interval p = intervals.get(i);
			if(p.start > result.get(result.size()-1).end){
				result.add(p);
			}else if(p.end > result.get(result.size()-1).end){
				result.get(result.size()-1).end = p.end;
			}
		}
		return result;
    }
}