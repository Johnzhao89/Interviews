package CH15;

/****************** Exercise 9 *****************
 * Create the classes necessary for the Peel<Banana>
 * example and show that the compiler doesn¡¯t accept
 * it. Fix the problem using an ArrayList.
 ***********************************************/

import java.util.*;

class Banana {
	private static int id;
	private final int number;

	Banana() {
		this.number = id++;
	}

	public String toString() {
		return getClass().getSimpleName() + " " + number;
	}
}

class Peel<T>{
	T fruit;
	Peel(T fruit){
		this.fruit = fruit;
	}
	void peel() { System.out.println("Peeling "+ fruit); }
}

public class E09_PeelBanana{
	public static void main(String[] args){
		ArrayList<Peel<Banana>> a = new ArrayList<Peel<Banana>>();
		for(int i =0;i<10;i++)
			a.add(new Peel<Banana>(new Banana()));
		for(Peel<Banana> p:a)
			p.peel();
	}
}
