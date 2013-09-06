package CH5;
import java.util.*;
import CtCILibrary.*;

public class Question1{
	public static int updateBits(int n, int m, int i, int j){
		if(i>=32 || j<i){
			return 0;
		}
		int allOnes = ~0;
		int left = allOnes<<(j+1);
		int right =((1<<i)-1);
		int mask = left|right;
		
		int n_cleared = n & mask;
		int m_shifted = m << i;
		return n_cleared | m_shifted;
	}
	
	public static void main(String[] args) {
		int a = 103217;
		System.out.println(AssortedMethods.toFullBinaryString(a));
		int b = 13;
		System.out.println(AssortedMethods.toFullBinaryString(b));		
		int c = updateBits(a, b, 4, 12);
		System.out.println(AssortedMethods.toFullBinaryString(c));
	}
}