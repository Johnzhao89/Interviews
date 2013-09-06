package CH9;
import java.util.*;
import CtCILibrary.*;

public class Question8{
	public static int makeChanges(int n, int[] denoms, int k){
		if(k>=denoms.length-1)
			return 1;
		int ways =0;
		for(int i=0; i*denoms[k]<=n; i++){
			ways+=makeChanges(n-i*denoms[k], denoms,k + 1);
		}
		return ways;
	}
	
	public static void main(String[] args){
		int[] denoms={25, 10, 5, 1};
		for (int i = 100; i <= 100; i++) {
			System.out.println("makeChange(" + i + ") = " + makeChanges(i,denoms,0));
		}
	}
}