package CH16;
/****************** Exercise 15 *****************
 * Repeat Exercise 13 using a SlowMap.
 ***********************************************/

import java.util.*;

public class E15_WordCounter2{
	public static void main(String[] args){
		List<String> words= Arrays.asList("A","B","C","D","E");
		SlowMap<String,Integer> map=
				new SlowMap<String,Integer>();
		for(String word: words){
			Integer freq= map.get(word);
			map.put(word, freq==null? 1:freq+1);
		}
		System.out.println(map);
	}
}