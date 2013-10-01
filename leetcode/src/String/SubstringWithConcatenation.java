package String;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
 * @author heguangliu
 *
 */
import java.util.*;
public class SubstringWithConcatenation{
	public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for(String s : L){
        	if(words.containsKey(s)){
        		words.put(s, 1+words.get(s));
        	}else{
        		words.put(s, 1);
        	}
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int len = L[0].length(), count = L.length;
        for(int i=0; i<= S.length()-count*len;i++){
        	HashMap<String, Integer> targets = new HashMap<String, Integer>(words);
        	int curr = i;
        	while(true){
        		String sub = S.substring(curr, curr+len);
        		if(targets.containsKey(sub)){
        			if(targets.get(sub)==1){
        				targets.remove(sub);
        			}else{
        				targets.put(sub,targets.get(sub)-1);
        			}
        			if(targets.isEmpty()){
        				result.add(i);
        				break;
        			}
        			curr+=len;
        		}else{
        			break;
        		}
        	}
        }
        return result;
    }
}