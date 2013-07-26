package CH2;
import java.util.*;

public class BitManipulation{
	public static void main(String[] args){
		Random rand = new Random(47);
		
		printBinaryInt("-1", -1);
	    printBinaryInt("+1", +1);
	    printBinaryLong("-1L", -1L);
	    printBinaryLong("+1L", +1L);
	    
		int i = rand.nextInt();
		int j = rand.nextInt();
		
		printBinaryInt("i", i);
	    printBinaryInt("~i", ~i);
	    printBinaryInt("-i", -i);
	    printBinaryInt("j", j);
	    printBinaryInt("i & j", i & j);
	    printBinaryInt("i | j", i | j);
	    printBinaryInt("i ^ j", i ^ j);
	    printBinaryInt("i << 5", i << 5);
	    printBinaryInt("i >> 5", i >> 5);
	    printBinaryInt("(~i) >> 5", (~i) >> 5);
	    printBinaryInt("i >>> 5", i >>> 5);
	    printBinaryInt("(~i) >>> 5", (~i) >>> 5);
		
		int maxpos = 2147483647;
		int maxneg = -2147483647;
		printBinaryInt("maxpos", maxpos);
		printBinaryInt("maxneg", maxneg);
		
		long l = rand.nextLong();
		long m = rand.nextLong();
		printBinaryLong("l", l);
	    printBinaryLong("~l", ~l);
	    printBinaryLong("-l", -l);
	    printBinaryLong("m", m);
	    printBinaryLong("l & m", l & m);
	    printBinaryLong("l | m", l | m);
	    printBinaryLong("l ^ m", l ^ m);
	    printBinaryLong("l << 5", l << 5);
	    printBinaryLong("l >> 5", l >> 5);
	    printBinaryLong("(~l) >> 5", (~l) >> 5);
	    printBinaryLong("l >>> 5", l >>> 5);
	    printBinaryLong("(~l) >>> 5", (~l) >>> 5);
		
		long ll = 9223372036854775807L;
		long lln = -9223372036854775808L;
	}
	static void printBinaryInt(String s, int i){
		System.out.println(s + ", int: " + i + ", binary:\n " + Integer.toBinaryString(i));
	}
	static void printBinaryLong(String s, long l){
		System.out.println(s + ", long: "+l + ", binary:\n "+ Long.toBinaryString(l));
	}
	
}