package CH9;

public class TestBed{
	public void f(){
		System.out.println("f()");
	}
	public static class Tester{
		public static void mian(String[] args){
			TestBed t = new TestBed();
			t.f();
		}
	}
}