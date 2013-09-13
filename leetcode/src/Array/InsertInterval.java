package Array;
/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * @author heguangliu
 *
 */
import java.util.*;

public class InsertInterval{
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
		ArrayList<Interval> result = new ArrayList<Interval>();
		if(intervals==null || intervals.size() == 0){
			result.add(newInterval);
			return result;
		}
		int i =0;
		for(; i<intervals.size();i++){
			if(intervals.get(i).start < newInterval.start){
				result.add(intervals.get(i));
			}else{
				break;
			}
		}
		if(i==0){
			 result.add(newInterval);
		}else if(result.get(result.size()-1).end<newInterval.start){
			 result.add(newInterval);
		}else if(result.get(result.size()-1).end < newInterval.end){
			 result.get(result.size()-1).end = newInterval.end;
		}
		
		for(int j=i; j< intervals.size(); j++){
			Interval p = intervals.get(j);
			if(result.get(result.size()-1).end< p.start){
				result.add(p);
			}else if(result.get(result.size()-1).end < p.end){
				result.get(result.size()-1).end = p.end;
			}
		}
		return result;
	}
}