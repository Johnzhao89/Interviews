package CH1;
import java.util.*;
/**
 * 
 * @author heguangliu
 *
 */

public class Question1{
	// use array
	public static boolean isUniqueChars0(String str){
		if(str.length()>256)
			return false;
		boolean[] char_set = new boolean[256];
		for(char c: str.toCharArray()){
			if(char_set[c]==true)
				return false;
			else
				char_set[c]=true;
		}
		return true;
	}
	//use set
	public static boolean isUniqueChars1(String str){
		if(str.length()>256)
			return false;
		Set<Character> set = new HashSet<Character>();
		for(char c: str.toCharArray()){
			if(set.contains(c))
				return false;
			set.add(c);
		}
		return true;
	}
	// use bit vector, assume only 26
	public static boolean isUniqueChars2(String str){
		if(str.length()>256){
			return false;
		}
		int checker =0;
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i)-'a';
			if((checker & (1<<val))>0)
				return false;
			checker|=(1<<val);
		}
		return true;
	}
	
	public static void main(String[] args){
		String[] words= {"abcde", "hello", "apple", "kite", "padle"};
		for(String word: words){
			System.out.println(word+": "+isUniqueChars0(word)+", "+isUniqueChars1(word)+", "+isUniqueChars2(word)+", ");
		}
	}
}