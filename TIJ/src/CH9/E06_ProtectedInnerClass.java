package CH9;
/****************** Exercise 6 *****************
 * Create an interface with at least one method,
 * in its own package. Create a class in a
 * separate package. Add a protected inner class
 * that implements the interface. In a third
 * package, inherit from your class and, inside a
 * method, return an object of the protected
 * inner class, upcasting to the interface during
 * the return.
 ***********************************************/
interface SimpleInterface{
	void f();
}

class SimpleClass{
	protected class Inner implements SimpleInterface{
		public Inner() {}
		public void f() {}
	}
}

public class E06_ProtectedInnerClass extends SimpleClass{
	public SimpleInterface get(){
		return new Inner();
	}
	public static void main(String[] args){
		new E06_ProtectedInnerClass().get().f();
	}
}









