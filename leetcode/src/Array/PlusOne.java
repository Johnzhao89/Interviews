package Array;

import java.util.Arrays;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * @author heguangliu
 *
 */
public class PlusOne{
	public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry =1;
        for(int i=digits.length -1; i>=0; i--){
        	int sum = carry+digits[i];
        	digits[i]=sum % 10;
        	carry = sum/10;
        	if(carry == 0 && i!=0)
        		break;
        }
        if(carry!=0){
        	int [] result = new int[digits.length+1];
        	result[0]=carry;
        	for(int i=0; i<digits.length;i++){
        		result[i+1]=digits[i];
        	}
        	return result;
        }
        return digits;
    }
}