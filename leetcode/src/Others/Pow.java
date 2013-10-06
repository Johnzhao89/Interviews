package Others;

public class Pow {
	public double powR(double x, int n) {
		if (n == 0)
			return 1;
		int exp = Math.abs(n);
		double half = powR(x, exp >> 1);
		double result = half * half;
		if ((exp & 1) == 1)
			result *= x;
		return n > 0 ? result : 1.0 / result;
	}
	
	public double powI(double x, int n){
		double result =1;
		for(int m = Math.abs(n); m>0; x*=x, m>>=1){
			if((m&1)==1) result *= x;
		}
		return n>0? result: 1.0/result;
	}
}