package CH9;
import java.util.*;
import CtCILibrary.*;

public class Fibonacci{
	public static int fibonacci0(int i){
		if(i==0)
			return 0;
		if(i ==1)
			return 1;
		return fibonacci0(i-1)+fibonacci0(i-2);
	}
	
	public static int max =100;
	public static int[] fib = new int[max];
	
	
	public static int fibonacci1(int i){
		if(i ==0){
			return 0;
		}
		if(i == 1){
			return 1;
		}
		if(fib[i]!=0){
			return fib[i];
		}
		fib[i] = fibonacci1(i-1) + fibonacci1(i-2);
		return fib[i];
	}
	
	public static void main(String[] args) {
		int trials = 10; // Run code multiple times to compute average time.
		double[] times = new double[max]; // Store times
		
		for (int j = 0; j < trials; j++) { // Run this 10 times to compute
			for (int i = 0; i < max; i++) {
				fib = new int[max];
				long start = System.currentTimeMillis();
				fibonacci0(i);
				long end = System.currentTimeMillis();
				long time = end - start;
				times[i] += time; 
			}
		}
		
		for (int j = 0; j < max; j++) {
			System.out.println(j + ": " + times[j] / trials + "ms");
		}
	}
}