package CH5;
import java.util.*;
import CtCILibrary.*;

public class Question3{
	
	//find first non-trailing 0 
	//set pth bit to 1
	//set all bits following p to 0
	//set bits zero 0 through c1-1 to 1
	public static int getNext(int n){
		int c = n;
		int c0 = 0;//number of zero
		int c1 = 0;//number of 1
		while(((c & 1)==0)&&(c != 0)){
			c0 ++;
			c >>= 1;
		}
		while((c & 1)==1){
			c1++;
			c >>=1;
		}
		if(c0+c1 == 31 || c0+c1 ==0){
			return -1;
		}
		int pos = c0+c1;//position of right-most non-trailing zero 
		n |= (1<<pos);
		// clear all bits right of pos
		n&= ~((1 << pos)-1);
		//put c1-1 on the most right side
		n|= (1<<(c1-1))-1;
		return n;
	}
	
	public static int getNextArith(int n){
		int c =n;
		int c0=0;
		int c1=0;
		while((c&1)==0 && c!=0){
			c0++;
			c >>=1;
		}
		while((c&1)==1){
			c1++;
			c>>=1;
		}
		if(c0+c1 == 31 || c0+c1 ==0){
			return -1;
		}
		return n+(1<< c0)+(1<<(c1-1))-1;
	}
	
	public static int getPrevArith(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while (((temp & 1) == 1) && (temp != 0)) {
			c1++;
			temp >>= 1;
		}
		
		/* If temp is 0, then the number is a sequence of 0s followed by a sequence of 1s. This is already
		 * the smallest number with c1 ones. Return -1 for an error.
		 */
		if (temp == 0) { 
			return -1;
		}
		
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}

		/* Arithmetic:
		 * 2^c1 = 1 << c1
		 * 2^(c0 - 1) = 1 << (c0 - 1)
		 */
		return n - (1 << c1) - (1 << (c0 - 1)) + 1;		
	}
	// find first non_trailing 1 ,c1 is trailing 1, c0 is right side 0
	//set the pth bit to 0
	//set all bits following p to 1
	//set bits 0 through c0-1 to 0
	public static int getPrev(int n){
		int c =n;
		int c0=0, c1=0;
		while((c & 1)==1){
			c1++;
			c>>=1;
		}
		if(c ==0){
			return -1;
		}
		while(((c&1)==0)&&(c!=0)){
			c0++;
			c>>=1;
		}
		int p=c0+c1;
		//clear bits on right side, clear the 
		n &= ((~0)<<(p + 1));
		
		int mask =(1<<(c1 + 1))-1;// right side c1+1 1
		n|= mask<<(c0-1);// move 1 to left most side
		return n;
	}
	
	
}