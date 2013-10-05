package String;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 For example:
 Given "25525511135",
 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * @author heguangliu
 *
 */
import java.util.*;

public class RestoreIPAddresses {
	public static ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() < 4)
			return result;
		ArrayList<String> curr = new ArrayList<String>();
		restoreIPAddress(s, 4, result, curr);
		return result;
	}

	public static void restoreIPAddress(String s, int d, ArrayList<String> result,
			ArrayList<String> curr) {
		if (d == 1) {
			if (isValidField(s)){
				String res = "";
				for (String e : curr)
					res += e + ".";
				res += s;
				result.add(res);
			}
			return;
		}
		for(int i =1; i<=3&& i<=s.length(); i++){
			String num = s.substring(0,i);
			curr.add(num);
			if(isValidField(num)){
				restoreIPAddress(s.substring(i), d-1, result, curr);}
			curr.remove(curr.size()-1);
		}
	}

	private static boolean isValidField(String s) {
		if (s.length() == 1
				|| (!s.isEmpty() && s.length() < 4 && !s.startsWith("0"))) {
			int num = Integer.parseInt(s);
			if (num >= 0 && num <= 255)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		System.out.println(restoreIpAddresses("101023"));
	}

	public ArrayList<String> restoreIpAddresses2(String s) {  
		   return restoreIPAddressesHelper2(s, 4);  
		 } 
	
	private ArrayList<String> restoreIPAddressesHelper2(String s, int fields) {
		ArrayList<String> results = new ArrayList<String>();
		if (fields == 1) {
			if (isValidField(s))
				results.add(s);
			return results;
		}

		for (int i = 1; i <= 3 && i <= s.length(); i++) {
			String num = s.substring(0, i);
			if (!isValidField(num))
				return results;
			ArrayList<String> substrings = restoreIPAddressesHelper2(
					s.substring(i), fields - 1);
			for (String substr : substrings)
				results.add(num + "." + substr);
		}
		return results;
	}
}