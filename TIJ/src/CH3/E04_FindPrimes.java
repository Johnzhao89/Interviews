package CH3;

/****************** Exercise 4 ******************
 * Write a program to detect and print prime numbers
 * (integers evenly divisible only by themselves
 * and 1), using two nested for loops and the
 * modulus operator (%).
 ************************************************/
public class E04_FindPrimes{
	public static boolean isPrime(int i){
		for (int j=2; j < i; j++){
			if(i % j == 0)
				return false;
		}
		return true;
	}
	
	public static boolean[] isPrime2(int max){
		boolean[] sieve = new boolean[max+1];
		int limit = (int)Math.floor(Math.sqrt(max));
		for(int i = 3; i <= limit; i += 2)
			if(!sieve[i])
				for(int j = 2*i; j <= max; j+=i )
					sieve[j] = true;
		return sieve;
	}
	
	public static void main(String[] args){
		int max = 100;
		if(args.length != 0){
			max = Integer.parseInt(args[0]);
		}
		System.out.println("General method: ");
		for(int i=1; i<max; i++)
			if(isPrime(i))
				System.out.print(i+" ");
		System.out.println("\nFast methos: ");
		if(max >= 2)
			System.out.print(2 +" ");
		boolean prime[]=isPrime2(max);
		
		for(int i = 3; i <= max; i += 2)
			if(!prime[i])
				System.out.print(i + " ");
	}
}