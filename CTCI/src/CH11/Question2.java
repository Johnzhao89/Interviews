package CH11;
import java.util.*;
import CtCILibrary.*;

public class Question2{
	public static class AngramComparator implements Comparator<String>{
		public String sortChars(String s){
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		public int compare(String s1, String s2){
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	
	public static String sortChars(String s){
		char [] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void sort(String[] array){
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for(String s: array){
			String key = sortChars(s);
			if(map.get(key)==null){
				map.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = map.get(key);
			anagrams.push(s);
		}
		int index =0;
		for(String key: map.keySet()){
			LinkedList<String> list = map.get(key);
			for(String t: list){
				array[index] = t;
				index++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sort(array);
		System.out.println(AssortedMethods.stringArrayToString(array));
		
		System.out.println(AssortedMethods.stringArrayToString(array));
		Arrays.sort(array, new AngramComparator());
		System.out.println(AssortedMethods.stringArrayToString(array));
	}
}