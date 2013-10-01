package String;
/**
 * Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. 
If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * @author heguangliu
 *
 */
public class StringToInteger{
	public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String pattern = "(^\\s*)([+-]?[0-9]+)(.*$)";
        if(!str.matches(pattern))
        	return 0;
        String numstr = str.replaceAll(pattern, "$2");
        
        int sign = (numstr.charAt(0)=='-')? -1: 1;
        long res = 0;
        for(int i = (numstr.charAt(0)== '+' ||numstr.charAt(0)=='-')? 1:0; i<numstr.length();i++){
        	res = res*10+(numstr.charAt(i)-'0');
        	if(res>Integer.MAX_VALUE)
        		return sign == -1? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
        return (int) (res*sign);
    }
	
	public int atoi2(String str){
		long result =0;
		int index =0;
		while(index < str.length() && str.charAt(index)==' ') index++;
		if(index == str.length())
			return (int) result;
		int sign = str.charAt(index)=='-'? -1: 1;
		while(index < str.length() && Character.isDigit(str.charAt(index))){
			result = result*10+ (str.charAt(index++)-'0');
			if(result > Integer.MAX_VALUE)
				return sign == -1? Integer.MIN_VALUE: Integer.MAX_VALUE;
		}
		return (int) (result* sign);
	}
}