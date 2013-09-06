package CH5;

import java.util.*;
import CtCILibrary.*;

public class Question6 {
// 32-bit system
	public static int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1));
	}
	public static void main(String[] args) {
		int a = 103217;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
	}

}