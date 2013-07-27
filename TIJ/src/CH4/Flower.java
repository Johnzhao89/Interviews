package CH4;

public class Flower{
	int petalCount = 0;
	String s = "initial value";
	
	Flower() {
		this("hi", 47);
	    System.out.println("default constructor (no args)");
	  }
	
	Flower(int petals){
		petalCount = petals;
		System.out.println("Constructor w/ int arg only, petalCount= "
			      + petalCount);
	}
	
	Flower(String ss){
		 System.out.println("Constructor w/ String arg only, s = " + ss);
		 s= ss;
	}
	
	Flower(String s, int petals) {
		this(petals);
		this.s = s;
	    //! this(s); // Can¡¯t call two!
	     // Another use of "this"
	    System.out.println("String & int args");
	  }
	void printPetalCount() {
		//! this(11); // Not inside non-constructor!
		System.out.println("petalCount = " + petalCount + " s = "+ s);
	}
	
	public static void main(String[] args) {
	    Flower x = new Flower();
	    x.printPetalCount();
	}
}