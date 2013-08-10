package CH11;

@SuppressWarnings("serial")
class MyException2Test extends Exception {
	private int x;

	public MyException2Test() {
	}

	public MyException2Test(String msg) {
		super(msg);
	}

	public MyException2Test(String msg, int x) {
		super(msg);
		this.x = x;
	}

	public int val() {
		return x;
	}

	public String getMessage() {
		return "Detail Message: " + x + " " + super.getMessage();
	}
}

class ExtraFeatures {
	public static void f() throws MyException2Test {
		System.out.println("Throwing MyException2 from f()");
		throw new MyException2Test();
	}

	public static void g() throws MyException2Test {
		System.out.println("Throwing MyException2 from g()");
		throw new MyException2Test("Originated in g()");
	}

	public static void h() throws MyException2Test {
		System.out.println("Throwing MyException2 from h()");
		throw new MyException2Test("Originated in h()", 47);
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (MyException2Test e) {
			e.printStackTrace(System.out);
		}
		try {
			g();
		} catch (MyException2Test e) {
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (MyException2Test e) {
			e.printStackTrace(System.out);
			System.out.println("e.val() = " + e.val());
		}
	}
}
