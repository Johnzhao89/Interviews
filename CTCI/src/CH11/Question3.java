package CH11;

import java.util.*;
import CtCILibrary.*;

public class Question3 {
	public static int search(int a[], int left, int right, int x) {
		int mid= (left+right)/2;
		if(x==a[mid])
			return mid;
		if(right<left)
			return -1;
		if(a[left]<a[mid]){// left is normal ordered
			if(x>=a[left] && x<=a[mid]){
				return search(a,left,mid-1,x);
			}else{
				return search(a,mid+1,right,x);
			}
		}else if(a[mid]<a[left]){// right side is normal
			if(x>=a[mid]&& x<=a[right]){
				return search(a,mid+1, right,x);
			}else{
				return search(a, left, mid-1,x);
			}
		}else if(a[left]==a[mid]){
			if(a[mid]!=a[right]){
				return search(a,mid+1, right,x);
			}else{
				int result = search(a, left, mid-1,x);
				if(result ==-1){
					return search(a, mid+1, right,x);
				}else{
					return result;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 2, 2, 2, 2, 2, 2, 2, 2 };

		System.out.println(search(a, 0, a.length - 1, 2));
		System.out.println(search(a, 0, a.length - 1, 3));
		System.out.println(search(a, 0, a.length - 1, 4));
		System.out.println(search(a, 0, a.length - 1, 1));
		System.out.println(search(a, 0, a.length - 1, 8));
	}
}