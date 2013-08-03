package CH7;
/****************** Exercise 5 ****************
 * Starting from Exercise 1, add a wheels()
 * method in Cycle, which returns the number of
 * wheels. Modify ride() to call wheels() and
 * verify that polymorphism works.
 ***********************************************/
class Cycle2{
	public int wheels(){
		return 0;
	}
}
class Unicycle2 extends Cycle2{
	public int wheels(){
		return 1;
	}
}
class Bicycle2 extends Cycle2{
	public int wheels(){
		return 2;
	}
}

class Tricycle2 extends Cycle2{
	public int wheels(){
		return 3;
	}
}

public class E05_Wheels{
	public static void ride(Cycle2 c){
		System.out.println("Num. of wheels: "+ c.wheels());
	}
	
	public static void main(String[] args){
		ride(new Unicycle2());
		ride(new Bicycle2());
		ride(new Tricycle2());
	}
}