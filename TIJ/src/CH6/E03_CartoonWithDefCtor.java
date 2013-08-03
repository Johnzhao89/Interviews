package CH6;
/****************** Exercise 3 ******************
 * Even if you don't create a constructor for
 * Cartoon(), the compiler will synthesize a
 * default constructor that calls the base-class
 * constructor. Prove that assertion.
 ***********************************************/
class Art{
	Art(){System.out.println("Art constructor");}
}
class Drawing extends Art{
	Drawing() { System.out.println("Drawing constructor");}
}
class CartoonWithDefCtor extends Drawing{
	//!  CartoonWithDefCtor() {
    //!    System.out.println("CartoonWithDefCtor constructor");
    //!  }
}
public class E03_CartoonWithDefCtor{
	public static void main(String[] args){
		new CartoonWithDefCtor();
	}
}