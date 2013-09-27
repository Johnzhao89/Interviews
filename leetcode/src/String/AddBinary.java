package String;

/**
 * Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".
 * @author heguangliu
 */
public class AddBinary{
	public static String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a==null || a.isEmpty())
        	return b;
        if(b == null || b.isEmpty())
        	return a;
        a = reverse(a); b = reverse(b);
        int carry =0;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<Math.max(a.length(), b.length()); i++){
        	int sum = getValue(a,i)+getValue(b,i)+carry;
        	carry = sum/2;
        	sb.append(sum%2);
        }
        if(carry == 1) 
        	sb.append("1");
        return sb.reverse().toString();
    }
	public static int getValue(String str, int i){
		if(i<0 || i > str.length()-1)
			return 0;
		return str.charAt(i)-'0';
	}
	
	public static String reverse(String str){
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--)
			sb.append(str.charAt(i));
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println(addBinary("1","1"));
	}
	
}