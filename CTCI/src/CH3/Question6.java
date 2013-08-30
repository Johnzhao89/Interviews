package CH3;

import java.util.*;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 * 
 */
public class Question6 {
	public static Stack<Integer> sort(Stack<Integer> source) {
		Stack<Integer> result = new Stack<Integer>();
		while (!source.isEmpty()) {
			int tmp = source.pop();// CAUTION: Collections.isEmpty() and
									// Collecyions==null
			while (!result.isEmpty() && result.peek() > tmp) {
				source.push(result.pop());
			}
			result.push(tmp);
		}
		return result;
	}

	public static Stack<Integer> mergesort(Stack<Integer> inStack) {
		if (inStack.size() <= 1) {
			return inStack;
		}
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();
		int count = 0;
		while (inStack.size() != 0) {
			count++;
			if (count % 2 == 0)
				left.push(inStack.pop());
			else
				right.push(inStack.pop());
		}
		left = mergesort(left);
		System.out.println("Left " + left);
		right = mergesort(right);
		System.out.println("Right " + right);//CAUTION : must reverse in this case
		while (left.size() > 0 || right.size() > 0) {
			if (left.size() == 0) {
				inStack.push(right.pop());
			} else if (right.size() == 0) {
				inStack.push(left.pop());
			} else if (right.peek().compareTo(left.peek()) <= 0) {
				inStack.push(left.pop());
			} else {
				inStack.push(right.pop());
			}
		}
		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0) {
			reverseStack.push(inStack.pop());
		}

		return reverseStack;
	}


	public static void main(String[] args) {
		for (int k = 1; k < 2; k++) {
			Stack<Integer> s = new Stack<Integer>();
			Stack<Integer> s1 = new Stack<Integer>();
			for (int i = 0; i < 10 * k; i++) {
				int r = AssortedMethods.randomIntInRange(0, 1000);
				int r1 = AssortedMethods.randomIntInRange(0, 1000);
				s.push(r);
				s1.push(r1);
				System.out.print(s.peek() + " ");
			}
			s = sort(s);
			s1 = mergesort(s1);
			System.out.println("\n sort result:");

			int last = Integer.MAX_VALUE;
			while (!s.isEmpty()) {
				int curr = s.pop();
				System.out.print(curr + " ");
				last = curr;
			}
			System.out.println("merge result");
			while (!s1.isEmpty()) {
				int curr = s1.pop();
				System.out.print(curr + " ");
				last = curr;
			}
		}
	}
}