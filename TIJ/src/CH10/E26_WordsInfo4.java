package CH10;
/****************** Exercise 26 *****************
 * Take the resulting Map from the previous
 * exercise and recreate the order of the words as
 * they appeared in the original file.
 ***********************************************/
import java.util.*;

public class E26_WordsInfo4{
	public static void main(String[] args){
		Map<String,ArrayList<Integer>> stat =
				new HashMap<String, ArrayList<Integer>>();
		int wordCount = 0;
		List<String> origWords = new LinkedList<String>();
		
		for(String word: origWords){
			ArrayList<Integer> loc = stat.get(word);
			if(loc == null){
				loc = new ArrayList<Integer>();
				stat.put(word,loc);
			}
			loc.add(++wordCount);
		}
		
		TreeMap<Integer,String> words= new TreeMap<Integer,String>();
		for(Map.Entry<String,ArrayList<Integer>> entry: stat.entrySet())
			for(Integer pos: entry.getValue())
				words.put(pos, entry.getKey());
		System.out.println(origWords);
		System.out.println(words.values());
	}
}
