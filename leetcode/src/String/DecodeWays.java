package String;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping: 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message
 * containing digits, determine the total number of ways to decode it. For
 * example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L"
 * (12). The number of ways decoding "12" is 2.
 * 
 * @author heguangliu
 * 
 */
public class DecodeWays {
	public int numDecodings(String s){
		if(s == null ||s.length()==0 ||s.startsWith("0")) return 0;
		if(s.length() == 1) return 1;
		int[] count = new int[s.length()];
		count[0]= isValid(s.substring(0, 1))? 1: 0;
		
		if(isValid(s.substring(0,2)))count[1]++;
		if(isValid(s.substring(1,2))) count[1]+=count[0];
		
		for(int i=2; i< s.length(); i++){
			if(isValid(s.substring(i,i+1))) count[i]+=count[i-1];
			if(isValid(s.substring(i-1,i+1))) count[i]+=count[i-2];
		}
		return count[s.length()-1];
	}
	
	public boolean isValid(String str){
		if(str.length() == 1)
			return !str.equals("0");
		if(str.length() == 2)
			return !str.startsWith("0") &&Integer.parseInt(str)>0 && Integer.parseInt(str)<=26;
		return false;
	}
}