package CH1;
import java.util.*;
/**
 * 
 * @author heguangliu
 *
 */

public class Question3{
	
	public static boolean permutation0(String str1, String str2){
		if(str1.length()!=str2.length())
			return false;
		char[] array1= str1.toCharArray();
		char[] array2 = str2.toCharArray();
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		if(new String(array1).equals(new String(array2)))
			return true;
		return false;
	}
	
	public static boolean permutation1(String str1, String str2){
		if(str1.length()!=str2.length())
			return false;
		
		int[] dict= new int[256];
		for(char c: str1.toCharArray())
			dict[c]++;
		
		for(char c: str2.toCharArray()){
			dict[c]--;
			if(dict[c]<0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String[][] pairs ={{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for(String[] pair: pairs){
			String word1= pair[0];
			String word2= pair[1];
			boolean anagram0 = permutation0(word1, word2);
			boolean anagram1 = permutation1(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram0+" "+anagram1);
		}
	}
	
}

