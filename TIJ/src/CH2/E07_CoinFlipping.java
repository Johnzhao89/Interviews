package CH2;
/****************** Exercise 7 *****************
 * Write a program that simulates coin-flipping.
 ***********************************************/
import java.util.Random;

public class E07_CoinFlipping {
	public static void main(String[] args){
		Random rand = new Random();
		boolean flip = rand.nextBoolean();
		System.out.println("OUTCOME: ");
		System.out.println(flip? "TAIL":"HEAD");
	}
}

