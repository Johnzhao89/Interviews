package Others;

/**
 * Implement int sqrt(int x).
Compute and return the square root of x.
 * @author heguangliu
 *
 */
public class Sqrt{
	
	//binary search O(log n)
	public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 2) return x;
        int low =0, high =x;
        while(high - low >1){
        	int mid = low +(high - low)/2;
        	int div = x/mid;
        	if(mid == div) return mid;
        	if(mid < div) low = mid;
        	else high = mid;
        }
        return low;
    }
}