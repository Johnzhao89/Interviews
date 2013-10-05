package Array;

public class SingleNumberII {
	public static int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if(A==null || A.length==0)
			return -1;
		StringBuilder result=new StringBuilder();
		int sign =0;
		for(int i=0; i< 31; i++){
			int sum =0;
			for(int j =0; j<A.length; j++){
				if(i ==0 && A[j]>0) sign++; 
				if((A[j] & (1<<i))!=0){
					sum++;
				}
			}
			result.append(sum % 3!=0? 1:0);
		}
		sign = sign%3;
		int value= Integer.parseInt(result.reverse().toString(), 2);
		return (int) (sign!=0? value: -(Math.pow(2, 31)-value));
	}
	public static void main(String args[]){
		int[] A ={-2,-2,1,1,-3,1,-3,-3,-4,-2 };
		System.out.println(singleNumber(A));
	}
}