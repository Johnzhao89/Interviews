package CH3;

/****************** Exercise 9 **********************
 * A Fibonacci sequence is the sequence of numbers 1,
 * 1, 2, 3, 5, 8, 13, 21, 34, etc., where each
 * number (from the third on) is the sum of the previous
 * two. Create a method that takes an integer as an
 * argument and displays that many Fibonacci numbers
 * starting from the beginning. If, e.g., you run java
 * Fibonacci 5 (where Fibonacci is the name of the
 * class) the output will be: 1, 1, 2, 3, 5.
 ****************************************************/

public class E09_Fibonacci{
	static int fib(int n){
		if(n <= 2)
			return 1;
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args){
		int n = 10;
		if(args.length>0)
			n= Integer.parseInt(args[0]);
		for(int i = 1; i<= n; i++)
			System.out.print(fib(i)+", ");
	}
}