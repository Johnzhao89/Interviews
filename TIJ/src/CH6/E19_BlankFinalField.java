package CH6;
/****************** Exercise 19 *****************
 * Create a class with a blank final reference to
 * an object. Perform initialization of the
 * blank final inside all constructors.
 * Demonstrate that the final must
 * be initialized before use, and cannot
 * be changed once initialized.
 ***********************************************/

class WithBlankFinalField{
	private final Integer i;
	public WithBlankFinalField(int ii){
		i = new Integer(ii);
	}
	public Integer geti(){
		return i;
	}
}

public class E19_BlankFinalField{
	public static void main(String[] args){
		WithBlankFinalField wbff = new WithBlankFinalField(10);
        System.out.println(wbff.geti());
	}
}







