package CH4;
/****************** Exercise 9 *****************
 * Create a class with two (overloaded)
 * constructors. Using this, call the second
 * constructor inside the first one.
 ***********************************************/
public class E09_ThisConstructorCall{
	public E09_ThisConstructorCall(String s){
		System.out.println("s = " + s);
	}
	public E09_ThisConstructorCall(int i){
		this("i = " + i);
	}
	public static void main(String args[]){
		new E09_ThisConstructorCall("String call");
        new E09_ThisConstructorCall(47);
	}
}
