package CH6;
/****************** Exercise 23 ****************
 * Prove that class loading takes place only
 * once and may be caused by either the creation
 * of the first instance of that class or by
 * accessing a static member.
 ***********************************************/

class LoadTest{
	static {
		System.out.println("Loading LoadTest");
	}
	static void staticMember(){}
}

public class E23_ClassLoading{
	public static void mian(String[] args){
		System.out.println("Calling static member");
		LoadTest.staticMember();
		System.out.println("Creating an object");
		new LoadTest();
	}
	
}