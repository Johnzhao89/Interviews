package CH4;
/****************** Exercise 4 *****************
 * Add an overloaded constructor to Exercise 3 that
 * takes a String argument and prints it along with
 * your message.
 ***********************************************/

public class E04_OverloadedConstructor{
	E04_OverloadedConstructor(){
		System.out.println("Default constructor");
	}
	E04_OverloadedConstructor(String s){
		System.out.println("String arg constructor");
		System.out.println(s);
	}
	
	public static void main(String args[]){
		new E04_OverloadedConstructor();
		new E04_OverloadedConstructor("Overloaded");
	}
}