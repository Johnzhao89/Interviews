package CH3;

/****************** Exercise 2 ******************
 * Write a program to generate 25 random int
 * values. Use an if-else statement for each value
 * to classify it as greater than, less than, or
 * equal to a second randomly generated value.
************************************************/
import java.util.*;
public class E02_RandomInts{
	static Random r = new Random(47);
	
	public static void compareRand(){
		int a = r.nextInt();
		int b = r.nextInt();
		System.out.println("a = "+ a + ", b = "+b );
		if(a < b)
			System.out.println("a < b");
		else if(a == b)
			System.out.println("a = b");
		else 
			System.out.println("a > b");
	}
	
	public static void main(String[] args){
		for(int i = 0; i < 25; i++){
			compareRand();
		}
	}
}
