package CH11;

/******************
 * Exercise 4 ****************** Create your own exception class using the
 * extends keyword. Write a constructor for this class that takes a String
 * argument and stores it inside the object with a String reference. Write a
 * method that prints out the stored String. Create a try-catch clause to
 * exercise your new exception.
 ***********************************************/

@SuppressWarnings("serial") 
class MyExceptionTest extends Exception {
	String msg;

	public MyExceptionTest(String msg) {
		this.msg = msg;
	}

	public void printMsg() {
		System.out.println("msg = " + msg);
	}
}

// Or take a more clever approach,
// noting that string storage and printing are
// built into Exception:
@SuppressWarnings("serial")
class MyException2 extends Exception {
	public MyException2(String s) {
		super(s);
	}
}

public class E04_ExceptionClass {
	public static void main(String args[]) {
		try {
			throw new MyExceptionTest("MyException message");
		} catch (MyExceptionTest e) {
			e.printMsg();
		}
		try {
			throw new MyException2("MyException2 message");
		} catch (MyException2 e) {
			System.out.println("e.getMessage() = " + e.getMessage());
		}
	}
}