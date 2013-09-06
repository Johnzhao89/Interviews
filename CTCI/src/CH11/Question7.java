package CH11;

import java.util.*;
import CtCILibrary.*;

public class Question7 {
	static class HtWt implements Comparable{
		private int Ht;
		private int Wt;
		public HtWt(int h, int w){
			Ht = h;
			Wt =w;
		}
		// height first then weight
		public int compareTo(Object s){
			HtWt second = (HtWt)s;
			if(this.Ht!=second.Ht){
				return ((Integer)this.Ht).compareTo(second.Ht);
			}else{
				return ((Integer)this.Wt).compareTo(second.Wt);
			}
		}
		public String toString(){
			return "(" + Ht + ", " + Wt + ")";
		}
		
		public boolean isBefore(HtWt other){
			if (this.Ht < other.Ht && this.Wt < other.Wt) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items){
		Collections.sort(items);
		ArrayList<HtWt>[] solutions = new ArrayList[items.size()];
		longestIncreasingSubsequence(items, solutions, 0);
		ArrayList<HtWt> best_sequence = null;
		for(int i=0; i<items.size(); i++){
			best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
		}
		return best_sequence;
	}
	
	private static void longestIncreasingSubsequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index){
		if(current_index>=array.size() || current_index<0){
			return;
		}
		HtWt current_element = array.get(current_index);
		ArrayList<HtWt> best_sequence = null;
		for(int i=0; i<current_index; i++){
			if(array.get(i).isBefore(current_element)){
				best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
			}
		}
		ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
		if(best_sequence!=null){
			new_solution.addAll(best_sequence);
		}
		new_solution.add(current_element);
		solutions[current_index] = new_solution;
		longestIncreasingSubsequence(array, solutions, current_index+1);
	}
	
	private static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2){
		if(seq1 == null){
			return seq2;
		}else if (seq2==null){
			return seq1;
		}
		return seq1.size()>seq2.size() ? seq1:seq2;
	}
	
	
}