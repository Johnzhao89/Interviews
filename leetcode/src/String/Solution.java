package String;

import java.util.*;

public class Solution {
	int solution(int A[], int N){
		if(A == null|| A.length == 0 || N == 0|| N%2==0)
			return -1;
		if(N == 1)
			return A[0];
		
		int result=0;
		for(int a: A){
			result = result ^ a;
		}
		return result;
	}
	
	
}