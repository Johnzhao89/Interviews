package CH5;
import java.util.*;
import CtCILibrary.*;

public class Question5{
	public static int bitSwapRequired0(int a, int b){
		int count =0;
		for(int c = a^b; c!=0; c=c>>1){
			count += c&1;
		}
		return count;
	}
	// c&(c-1) clear the least significant bit in c
	public static int bitSwapRequired1(int a , int b){
		int count =0;
		for(int c= a^b; c!=0; c=c&(c-1)){
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a = 23432;
		int b = 512132;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
		int nbits = bitSwapRequired1(a, b);
		int nbits2 = bitSwapRequired0(a, b);
		System.out.println("Required number of bits: " + nbits + " " + nbits2);
	}
}