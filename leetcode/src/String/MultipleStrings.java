package String;

import java.util.Arrays;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
 * @author heguangliu
 *
 */
public class MultipleStrings{
	
	public static String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num1==null || num2==null || num1.isEmpty()||num2.isEmpty())
        	return new String();
        int[] array1 = toArray(num1);
        int[] array2 = toArray(num2);
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i =0; i<array1.length+array2.length-1; i++){
        	for(int j =0; j<=i;j++){
        		if(j<array1.length && i-j <array2.length){
        			sum += array1[j]* array2[i-j];
        		}
        	}
    		sb.append(String.valueOf(sum%10));
    		sum/=10;
        }
        if(sum > 0)
        	sb.append(String.valueOf(sum));
        String result = sb.reverse().toString().replaceAll("^0+","");// CAUTION!
        return result.equals("")? "0": result;
    }
	
	public static int[] toArray(String num){
		int[] result = new int[num.length()];
		for(int i=0; i< num.length(); i++){
			result[i] = num.charAt(num.length()-1-i)-'0';
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(multiply("123","123"));
	}
}