package CH16;
/****************** Exercise 19 *****************
 * Repeat Exercise 13 using a SimpleHashMap.
 ***********************************************/
import java.util.*;

public class E19_WordCounter3{
	public static void main(String[] args){
		List<String> words= new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
		SimpleHashMap<String, Integer> map = new SimpleHashMap<String, Integer>();
		for(String word: words){
			Integer freq= map.get(word);
			map.put(word, freq==null? 1: freq+1);
		}
		System.out.println(map);
		
	}
}
