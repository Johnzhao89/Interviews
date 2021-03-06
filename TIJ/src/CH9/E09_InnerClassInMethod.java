package CH9;
/****************** Exercise 9 *****************
 * Create an interface with at least one method,
 * and implement it by defining an
 * inner class within a method that returns a
 * reference to your interface.
 ***********************************************/
public class E09_InnerClassInMethod{
	
	public SimpleInterface get(){
		class SI implements SimpleInterface{
			public void f(){
				System.out.println("SI.f");}
		}
		return new SI();
	}
	
	public static void main(String[] args){
		SimpleInterface si = new E09_InnerClassInMethod().get();
		si.f();
	}
}